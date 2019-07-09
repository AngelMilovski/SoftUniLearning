function freelance() {
    let isLogged = false;
    const loginBtn = document.querySelector('#loginBtn');
    loginBtn.addEventListener('click', callback);
    const offerBtn = document.querySelector('#create-offer-Btn');
    offerBtn.addEventListener('click', createOffer);
    const input = document.querySelector('#username');
    let offers = document.querySelector('#offers-container');
    const startPageDiv = offers.cloneNode(true);
    

    function callback() {
        (isLogged) ? logout() : login();

        return this;
    }

    function login() {
        const username = input.value;
        if (username.length > 3 && username.length < 11) {
            document.querySelector('#notification').innerHTML = '';
            input.class = 'border-0 bg-light';
            input.value = `Hello, ${username}!`;
            input.disabled = true;
            loginBtn.innerHTML = 'Logout';
            isLogged = true;
        } else {
            const text = 'The username length should be between 4 and 10 characters.';
            document.querySelector('#notification').innerHTML = text;
        }
    }

    function createOffer() {
            const offerNameInput = document.querySelector('#offerName');
            const offerName = offerNameInput.value;
            const companyInput = document.querySelector('#company');
            const company = companyInput.value;
            const descriptionInput = document.querySelector('#description');
            const description = descriptionInput.value;
            offerNameInput.value = '';
            companyInput.value = '';
            descriptionInput.value = '';

            if (offerName && company && description && isLogged) {
                const div = offers.firstElementChild;
                const divEl = div.cloneNode(true);

                divEl.querySelector('.card-header').innerHTML = offerName;
                divEl.querySelector('.card-title').innerHTML = company;
                divEl.querySelector('.card-text').textContent = description;

                count += 1;
                offers.appendChild(divEl);
            }
        
    }

    function logout() {
        offers = startPageDiv.cloneNode(true);
        const div = document.querySelector('#offers');
        div.removeChild(div.lastElementChild);
        div.appendChild(offers);
        input.class = 'btn btn-outline-dark my-2 my-sm-0';
        input.value = ``;
        input.disabled = false;
        isLogged = false;
        loginBtn.innerHTML = 'Login';
    }
}