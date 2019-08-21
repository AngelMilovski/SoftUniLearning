function startApp() {
    // Clear user auth data
    sessionStorage.clear();

    // Show correct nav sections
    showHideMenuLinks();

    // Bind the navigation menu links
    $("#linkHome").click(showHomeView);

    // Bind the form submit actions
    // $("#formLogin").submit(loginUser);

    $("form").submit(function (e) {
        e.preventDefault();
    });

    $('main').click(() => {
        $('#infoBox').fadeOut();
        $('#errorBox').fadeOut();
    });

    // Bind the navigation menu links
    $("#linkHome").click(showHomeView);
    $("#linkLogin").click(showLoginView);
    $("#linkRegister").click(showRegisterView);
    $("#linkListBooks").click(listBooks);
    $("#linkCreateBook").click(showCreateBookView);
    $("#linkLogout").click(logoutUser);

    // Bind the form submit buttons
    $("#formLogin").submit(loginUser);
    $("#formRegister").submit(registerUser);
    $("#formCreateBook").submit(createBook);
    $("#formEditBook").submit(editBook);

    $('#errorBox').click(function () {
        $(this).fadeOut();
    });

    // Attach AJAX "loading" event listener
    $(document).on({
        ajaxStart: function () {
            $("#loadingBox").show();
        },
        ajaxStop: function () {
            $("#loadingBox").hide();
        },
    });

    const kinveyBaseUrl = 'https://baas.kinvey.com';
    const kinveyAppKey = 'kid_SkafYDtEr';
    const kinveyAppSecret = 'd9189914c6f04adf8599304c725fbebb';


    function showHideMenuLinks() {
        $('#menu a').hide();
        $('#menu span').hide();
        const test = sessionStorage.getItem('authToken');
        if (test) {
            $("#linkHome").show();
            $("#linkListBooks").show();
            $("#linkCreateBook").show();
            $("#linkLogout").show();
            $('#menu span').show();
        } else {
            $("#linkHome").show();
            $("#linkLogin").show();
            $("#linkRegister").show();
        }
    }

    function showView(viewName) {
        $('main section').hide();
        $('#' + viewName).show();
    }

    function showHomeView() {
        showView('viewHome');
    }

    function showLoginView() {
        showView('viewLogin');
        $('#formLogin').trigger('reset');
    }

    function showRegisterView() {
        showView('viewRegister');
        $('#formRegister').trigger('reset');
    }

    function listBooks() {
        $('#books').empty();
        showView('viewBooks');

        const endpoint = `/appdata/${kinveyAppKey}/books`;
        $.ajax({
            Method: 'GET',
            url: kinveyBaseUrl + endpoint,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Kinvey ${sessionStorage.getItem('authToken')}`,
                'X-Kinvey-API-Version': 3,
            },
            success: handleLoadBooksSuccess,
            error: handleError,
        });

        function handleLoadBooksSuccess(books) {
            showInfo('Books loaded.');

            if (!books.length) {
                $('#books').text('No books int the library');
            } else {
                let booksTable = $('<table>')
                    .append($('<tr>').append(
                        '<th>Title</th><th>Author</th>',
                        '<th>Description</th><th>Actions</th>'));
                books.forEach((book) => {
                    appendBookRow(book, booksTable);
                });

                $('#books').append(booksTable);
            }

            function appendBookRow(book, table) {

                let links = [];
                if (book._acl.creator == sessionStorage.getItem('userId')) {
                    let deleteLink = $('<a href="#">[Delete]</a>')
                        .click(deleteBook.bind(this, book));

                    let editLink = $('<a href="#">[Edit]</a>')
                        .click(loadBookForEdit.bind(this, book));

                    links = [deleteLink, ' ', editLink];
                }

                table
                    .append('<tr>')
                    .append(
                        $('<td>').text(book.title),
                        $('<td>').text(book.author),
                        $('<td>').text(book.description),
                        $('<td>').append(links),
                    );
            }

            function loadBookForEdit(book) {
                $('#formEditBook input[name=id]').val(book._id);
                $('#formEditBook input[name=title]').val(book.title);
                $('#formEditBook input[name=author]').val(book.author);
                $('#formEditBook textarea[name=descr]').val(book.description);
                showView('viewEditBook');
            }
        }

        function deleteBook(book) {
            const endpoint = `/appdata/${kinveyAppKey}/books/${book._id}`;
            $.ajax({
                method: "DELETE",
                url: kinveyBaseUrl + endpoint,
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Kinvey ${sessionStorage.getItem('authToken')}`,
                    'X-Kinvey-API-Version': 3,
                },
                success: deleteBookSuccess,
                error: handleError
            });

            function deleteBookSuccess() {
                listBooks();
                showInfo('Book deleted.');
            }
        }
    }

    function showCreateBookView() {
        showView('viewCreateBook');
        $('#formCreateBook').trigger('reset');
    }

    function logoutUser() {
        $('#loggedUser').text('');

        const endpoint = `/user/${kinveyAppKey}/_logout`;

        $.ajax({
            method: 'POST',
            url: kinveyBaseUrl + endpoint,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Kinvey ${sessionStorage.getItem('authToken')}`,
                'X-Kinvey-API-Version': 3,
            },
            success: handleLogoutUserSuccess,
            error: handleError,
        });

        function handleLogoutUserSuccess() {
            sessionStorage.clear();
            showHideMenuLinks();
            showView('homeView');
            showInfo('Successful logout.');
        }
    }

    function loginUser() {
        const userData = {
            username: $('#formLogin input[name="username"]').val(),
            password: $('#formLogin input[name="password"]').val(),
        };

        const endpoint = `/user/${kinveyAppKey}/login`;

        $.ajax({
            method: 'POST',
            url: kinveyBaseUrl + endpoint,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(kinveyAppKey + ':' + kinveyAppSecret),
                'X-Kinvey-API-Version': 3,
            },
            data: JSON.stringify(userData),
            success: handleLoginUserSuccess,
            error: handleError,
        });

        function handleLoginUserSuccess(userInfo) {
            saveAuthInSession(userInfo);
            showHideMenuLinks();
            showInfo('User registration successful.');
            listBooks();
        }
    }

    function registerUser() {
        const userData = {
            username: $('#formRegister input[name="username"]').val(),
            password: $('#formRegister input[name="password"]').val(),
        };

        const endpoint = `/user/${kinveyAppKey}`;

        $.ajax({
            method: 'POST',
            url: kinveyBaseUrl + endpoint,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(kinveyAppKey + ':' + kinveyAppSecret),
                'X-Kinvey-API-Version': 3,
            },
            data: JSON.stringify(userData),
            success: handleRegisterUserSuccess,
            error: handleError,
        });

        function handleRegisterUserSuccess(userInfo) {
            saveAuthInSession(userInfo);
            showHideMenuLinks();
            showInfo('User registration successful.');
            listBooks();
        }
    }

    function handleError(response) {
        let errorMsg = JSON.stringify(response);

        if (response.readyState === 0) {
            errorMsg = 'Cannot connect due to network error.';
        } else if (response.responseJSON && response.responseJSON.description) {
            errorMsg = response.responseJSON.description;
        }

        showError(errorMsg);
    }

    function showInfo(message) {
        $('#infoBox').text(message);
        $('#infoBox').show();
        setTimeout(() => {
            $('#infoBox').fadeOut();
        }, 3000);
    }

    function showError(message) {
        $('#errorBox').text('Error: ' + message);
        $('#errorBox').show();
    }

    function saveAuthInSession(userInfo) {
        sessionStorage.setItem('username', userInfo.username);
        sessionStorage.setItem('authToken', userInfo._kmd.authtoken);
        sessionStorage.setItem('userId', userInfo._id);
        $('#loggedUser').text(`Welcome, ${userInfo.username}!`);
    }

    function createBook() {
        const bookData = {
            title: $('#formCreateBook input[name="title"]').val(),
            author: $('#formCreateBook input[name="author"]').val(),
            description: $('#formCreateBook textarea[name="descr"]').val(),
        };

        const endpoint = `/appdata/${kinveyAppKey}/books`;

        $.ajax({
            method: 'POST',
            url: kinveyBaseUrl + endpoint,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Kinvey ${sessionStorage.getItem('authToken')}`,
                'X-Kinvey-API-Version': 3,
            },
            data: JSON.stringify(bookData),
            success: handleCreateBookSuccess,
            error: handleError,
        });

        function handleCreateBookSuccess() {
            showInfo('Created book.');
            listBooks();
        }
    }

    function editBook() {
        let bookData = {
            title: $('#formEditBook input[name=title]').val(),
            author: $('#formEditBook input[name=author]').val(),
            description:
                $('#formEditBook textarea[name=descr]').val()
        };

        $.ajax({
            method: "PUT",
            url: kinveyBaseUrl + "/appdata/" + kinveyAppKey +
                "/books/" + $('#formEditBook input[name=id]').val(),
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Kinvey ${sessionStorage.getItem('authToken')}`,
                'X-Kinvey-API-Version': 3,
            },
            data: JSON.stringify(bookData),
            success: editBookSuccess,
            error: handleError
        });

        function editBookSuccess() {
            listBooks();
            showInfo('Book edited.');
        }
    }
}