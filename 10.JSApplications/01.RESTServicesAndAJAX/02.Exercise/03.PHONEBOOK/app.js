function attachEvents() {
    const url = 'https://phonebook-nakov.firebaseio.com/phonebook.json';
    const ul = document.querySelector('#phonebook');
    

    const createDeleteBtn = (id) => {
        const btn = document.createElement('button');
        btn.id = id;
        btn.textContent = 'Delete';
        return btn;
    };

    const deletePhoneNumber = (evt) => {
        const { target } = evt;
        const id = target.id;
        target.parentNode.remove();
        const delUrl = `https://phonebook-nakov.firebaseio.com/phonebook/${id}.json`;
        const delMethod = {
            method: 'delete'
        };

        fetch(delUrl, delMethod)
            .catch(err => console.log(err));
    };

    const parseData = ([id, data]) => {
        return [
            id,
            {
                person: data.person,
                phone: data.phone
            }
        ];
    };

    const createLi = ([id, { person, phone }]) => {
        const li = document.createElement('li');
        li.textContent = `${person}: ${phone}`;
        const deleteBtn = createDeleteBtn(id);
        deleteBtn.addEventListener('click', deletePhoneNumber);
        li.appendChild(deleteBtn);

        return li;
    };

    const displayPhonebook = (data) => {
        Object
            .entries(data)
            .map(parseData)
            .map(createLi)
            .forEach(li => ul.appendChild(li));
    };

    const load = () => {
        ul.innerHTML = '';
        fetch(url)
            .then(res => res.json())
            .then(displayPhonebook)
            .catch(err => console.log(err));
    };

    const clearInputFields = (person, phone) => {
        person.value = '';
        phone.value = '';
    };

    const create = () => {
        const inputPerson = document.querySelector('#person');
        const inputPhone = document.querySelector('#phone');

        if (inputPerson.value && inputPhone.value) {
            const person = inputPerson.value;
            const phone = inputPhone.value;
            clearInputFields(inputPerson, inputPhone);
            const personPhone = { person, phone };
            const postData = {
                method: "post",
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify(personPhone)
            };

            fetch(url, postData)
                .then(res => res.json())
                .then(data => console.log(data.name))
                .catch(err => console.log(err));
        }
    };

    document.querySelector('#btnLoad').addEventListener('click', load);
    document.querySelector('#btnCreate').addEventListener('click', create);
}

attachEvents();