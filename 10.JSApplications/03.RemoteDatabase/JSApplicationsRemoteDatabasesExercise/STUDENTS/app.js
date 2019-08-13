(function () {
    let studentId = 1;
    const basicAuth = 'Basic ' + btoa('quest:quest');
    const url = 'https://baas.kinvey.com/appdata/kid_rkTb3u0-B/students';
    const tbody = document.querySelector('tbody');

    const trTemplate = (() => {
        const tr = document.createElement('tr');
        const idTd = document.createElement('td');
        const firsNameTd = document.createElement('td');
        const lastNameTd = document.createElement('td');
        const facultyNumberTd = document.createElement('td');
        const gradeTd = document.createElement('td');
        tr.appendChild(idTd);
        tr.appendChild(firsNameTd);
        tr.appendChild(lastNameTd);
        tr.appendChild(facultyNumberTd);
        tr.appendChild(gradeTd);
        return tr;
    })();

    const showAllStudents = ((data) => {
        tbody.innerHTML = '';
        data
            .sort((a, b) => a.id - b.id)
            .forEach((info) => {
                const { id, firstName, lastName, facultyNumber, grade } = info;
                const trElement = trTemplate.cloneNode(true);
                const trChildren = trElement.children;
                trChildren[0].innerHTML = id;
                trChildren[1].innerHTML = firstName;
                trChildren[2].innerHTML = lastName;
                trChildren[3].innerHTML = facultyNumber;
                trChildren[4].innerHTML = grade;
                tbody.appendChild(trElement);
            });
    });

    const loadStudents = (async function loadStudents() {
        const headers = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': basicAuth,
                'Credentials': 'include',
            }
        };
        try {
            const res = await fetch(url, headers);
            const data = await res.json();
            showAllStudents(data);
        } catch (err) {
            console.warn(err);
        }
    });

    const addStudent = (async function addStudent(evt) {
        evt.preventDefault();
        const firstNameInput = document.querySelector('#firstName');
        const lastNameInput = document.querySelector('#lastName');
        const facultyNumberInput = document.querySelector('#facultyNumber');
        const gradeInput = document.querySelector('#grade');
        const data = [firstName, lastName, facultyNumber, grade];

        data.map((input) => {
            switch (input.id) {
                case 'firstName':
                    input.placeholder = `First Name`;
                    break;

                case 'lastName':
                    input.placeholder = 'Last Name';
                    break;
            }

            input.style.border = '';
        });

        if (firstNameInput.value && lastNameInput.value && facultyNumberInput.value && gradeInput.value) {
            const id = ++studentId;
            const firstName = firstNameInput.value;
            const lastName = lastNameInput.value;
            const facultyNumber = +facultyNumberInput.value;
            const grade = +gradeInput.value;
            firstNameInput.value = '';
            lastNameInput.value = '';
            facultyNumberInput.value = '';
            gradeInput.value = '';

            const headers = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': basicAuth,
                    'Credentials': 'include',
                },
                body: JSON.stringify({ id, firstName, lastName, facultyNumber, grade }),
            };

            try {
                await fetch(url, headers);
                loadStudents(data);
            } catch (err) {
                console.warn(err);
            }

        } else {
            data
                .filter((input) => input.value === '')
                .map((input) => {
                    switch (input.id) {
                        case 'firstName':
                            input.placeholder = 'Please access First Name';
                            break;

                        case 'lastName':
                            input.placeholder = 'Please access Last Name';
                            break;
                    }

                    input.style.border = '1px solid red';
                });
        }
    });

    loadStudents();
    document.querySelector('button').addEventListener('click', addStudent);
}());