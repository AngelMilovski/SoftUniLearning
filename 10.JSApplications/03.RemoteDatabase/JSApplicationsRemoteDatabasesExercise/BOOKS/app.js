(function () {

    const selectors = {
        bookTitle: '#title',
        bookAuthor: '#author',
        bookIsbn: '#isbn',
        submitBtn: 'form button',
        loadBtn: '#loadBooks',
        table: '.tBodyBooks',
        trTemplate: 'table tbody tr',
        cancelEdit: '#cancelEdit',
        doneEdit: '#doneEdit'
    };

    const elements = {
        titleInput: document.querySelector(selectors.bookTitle),
        authorInput: document.querySelector(selectors.bookAuthor),
        isbnInput: document.querySelector(selectors.bookIsbn),
        submitBtn: document.querySelector(selectors.submitBtn),
        loadBtn: document.querySelector(selectors.loadBtn),
        tableBody: document.querySelector(selectors.table),
        trTemplate: document.querySelector(selectors.trTemplate),
        cancelEditBtn: document.querySelector(selectors.cancelEdit),
        doneEditBtn: document.querySelector(selectors.doneEdit),
    };

    attacheEvent(elements.submitBtn, createBook);
    attacheEvent(elements.loadBtn, loadBooks);

    const url = 'https://baas.kinvey.com/appdata/kid_rkTb3u0-B/books';
    // const basicAuthorization = 'Basic' + btoa('quest:quest');

    function loadBooks() {
        const data = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: 'include',
            // Authorization: 'Kinvey ' + localStorage.getItem('authToken'),
        };

        fetch(url, data)
            .then(handler)
            .then(displayBooks)
            .catch((err) => {
                console.warn(err);
            });
    }

    function displayBooks(data) {
        elements.tableBody.innerHTML = '';
        data.forEach((book) => {
            const tr = elements.trTemplate.cloneNode(true);
            tr.id = book._id;
            const childElements = tr.children;
            childElements[0].innerHTML = book.title;
            childElements[1].innerHTML = book.author;
            childElements[2].innerHTML = book.isbn;
            const editBtn = childElements[3].firstElementChild;
            const deleteBtn = childElements[3].lastElementChild;
            attacheEvent(editBtn, () => editBook(tr.id, book.title, book.author, book.isbn));
            attacheEvent(deleteBtn, deleteBook);
            elements.tableBody.appendChild(tr);
        });

        function editBook(id, title, author, isbn) {
            elements.titleInput.value = title;
            elements.authorInput.value = author;
            elements.isbnInput.value = isbn;
            elements.submitBtn.style.display = 'none';
            elements.cancelEditBtn.style.display = 'inline-block';
            elements.doneEditBtn.style.display = 'inline-block';

            elements.cancelEditBtn.addEventListener('click', (evt) => {
                evt.preventDefault();
                clearInputs();
                elements.submitBtn.style.display = 'block';
                elements.cancelEditBtn.style.display = 'none';
                elements.doneEditBtn.style.display = 'none';
                return;
            });

            elements.doneEditBtn.addEventListener('click', (evt) => {
                evt.preventDefault();
                const title = elements.titleInput.value;
                const author = elements.authorInput.value;
                const isbn = elements.isbnInput.value;
                const body = { title, author, isbn };

                if (title && author && isbn) {
                    clearInputs();
                    const data = {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        // Authorization: basicAuthorization,
                        credentials: 'include',
                        body: JSON.stringify(body),
                    };


                    fetch(url + `/${id}`, data)
                        .then(handler)
                        .then(loadBooks)
                        .then(() => {
                            elements.submitBtn.style.display = 'block';
                            elements.cancelEditBtn.style.display = 'none';
                            elements.doneEditBtn.style.display = 'none';

                        })
                        .catch(err => console.warn(err));
                }
            });
        }


        function deleteBook(evt) {
            const currentTr = evt.currentTarget.parentElement.parentElement;
            const id = currentTr.id;

            if (id) {
                currentTr.remove();
            }
            const data = {
                method: 'DELETE',
                // Authorization: 'Kinvey ' + localStorage.getItem('authToken'),
                credentials: 'include',
            };

            fetch(url + `/${id}`, data)
                .then(handler)
                .catch(err => console.warn(err));
        }
    }

    function createBook(evt) {
        evt.preventDefault();
        const title = elements.titleInput.value;
        const author = elements.authorInput.value;
        const isbn = elements.isbnInput.value;

        if (title, author, isbn) {
            clearInputs();
            const postBody = { title, author, isbn };
            const data = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                // Authorization: basicAuthorization,
                credentials: 'include',
                body: JSON.stringify(postBody),
            };

            fetch(url, data)
                .then(handler)
                .then(loadBooks)
                .catch(err => console.warn(err));
        }
    }

    function handler(response) {
        if (response.status >= 400) {
            throw new Error(`Error ${response.status} (${response.statusText})`);
        }

        return response.json();
    }

    function clearInputs() {
        elements.titleInput.value = '';
        elements.authorInput.value = '';
        elements.isbnInput.value = '';
    }

    function attacheEvent(element, functionName) {
        element.addEventListener('click', functionName);
    }
}());