(function attachEvents() {
    const selectors = {
        loadBtn: 'button.load',
        addBtn: 'button.add',
        updateBtn: 'button.update',
        deleteBtn: 'button.delete',
        template: 'div.catch',
        catches: '#catches',
        addForm: '#addForm',
        angler: 'input.angler',
        weight: 'input.weight',
        bait: 'input.bait',
        captureTime: 'input.captureTime',
        location: 'input.location',
        species: 'input.species'
    };

    const elements = ({
        loadBtn: document.querySelector(selectors.loadBtn),
        addBtn: document.querySelector(selectors.addBtn),
        updateBtn: document.querySelector(selectors.updateBtn),
        deleteBtn: document.querySelector(selectors.deleteBtn),
        catchTemplate: document.querySelector(selectors.template),
        catches: document.querySelector(selectors.catches),
        addForm: document.querySelector(selectors.addForm)
    });

    attachEventCurrentBtn(elements.loadBtn, loadAllCatches);
    attachEventCurrentBtn(elements.addBtn, addCatch);

    function loadAllCatches() {
        elements.catches.innerHTML = '';
        const url = 'https://fisher-game.firebaseio.com/catches.json';
        const headers = {
            method: 'GET'
        };
        fetch(url, headers)
            .then(handler)
            .then(displayData);
    }

    function handler(res) {
        if (res.status > 400) {
            throw new Error(`Error: ${res.status} (${res.statusText})`);
        }

        return res.json();
    }

    function createDiv([
        name, {
            angler,
            bait,
            captureTime,
            location,
            species,
            weight
        }
    ]) {
        const catchElement = elements.catchTemplate.cloneNode(true);
        catchElement.setAttribute('data-id', name);
        catchElement.querySelector(selectors.angler).value = angler;
        catchElement.querySelector(selectors.weight).value = weight;
        catchElement.querySelector(selectors.bait).value = bait;
        catchElement.querySelector(selectors.captureTime).value = captureTime;
        catchElement.querySelector(selectors.location).value = location;
        catchElement.querySelector(selectors.species).value = species;
        const updateBtn = catchElement.querySelector(selectors.updateBtn);
        const deleteBtn = catchElement.querySelector(selectors.deleteBtn);
        attachEventCurrentBtn(updateBtn, updateCurrentCatch);
        attachEventCurrentBtn(deleteBtn, deleteCurrentCatch);
        return catchElement;
    }

    function addToDom(div) {
        elements.catches.appendChild(div);
    }

    function displayData(data) {
        Object
            .entries(data)
            .map(createDiv)
            .forEach(addToDom);
    }

    function addCatch() {
        const anglerInput = getInputElementFromAddForm(selectors.angler);
        const weightInput = getInputElementFromAddForm(selectors.weight);
        const baitInput = getInputElementFromAddForm(selectors.bait);
        const captureTimeInput = getInputElementFromAddForm(selectors.captureTime);
        const locationInput = getInputElementFromAddForm(selectors.location);
        const speciesInput = getInputElementFromAddForm(selectors.species);

        if (anglerInput.value && weightInput.value &&
            baitInput.value && captureTimeInput.value &&
            locationInput.value && speciesInput.value) {

            const bodyObj = {
                angler: anglerInput.value,
                weight: weightInput.value,
                bait: baitInput.value,
                captureTime: captureTimeInput.value,
                location: locationInput.value,
                species: speciesInput.value
            };

            clearInputs([
                anglerInput,
                weightInput,
                baitInput,
                captureTimeInput,
                locationInput,
                speciesInput
            ]);

            const url = 'https://fisher-game.firebaseio.com/catches.json';
            const data = {
                method: 'Post',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(bodyObj)
            };

            fetch(url, data)
                .then(handler)
                .then(data => {
                    console.log(data);
                })
                .catch(err => console.warn(err));
        }
    }

    function getInputElementFromAddForm(selector) {
        return elements.addForm.querySelector(selector);
    }

    function clearInputs(arrOfInputs) {
        arrOfInputs.map(input => input.value = '');
    }

    function deleteCurrentCatch(evt) {
        const element = evt.currentTarget.parentElement;
        const id = element.getAttribute('data-id');
        const url = `https://fisher-game.firebaseio.com/catches/${id}.json`;
        const headers = { method: 'DELETE' };
        fetch(url, headers)
            .then(handler)
            .then(data => {
                element.remove();
                console.log(data);
            })
            .catch(err => console.warn(err));
    }

    function updateCurrentCatch(evt) {
        const element = evt.currentTarget.parentElement;
        const id = element.getAttribute('data-id');
        const info = Array
            .from(element.children)
            .filter(el => el.tagName === 'INPUT')
            .reduce((acc, cur) => {
                acc[cur.className] = cur.value;
                return acc;
            }, {});
        const url = `https://fisher-game.firebaseio.com/catches/${id}.json`;
        const data = { 
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(info)
         };

         fetch(url, data)
            .then(handler)
            .then(data => console.log(data))
            .catch(err => console.warn(err));
    }

    function attachEventCurrentBtn(element, functionName) {
        element.addEventListener('click', functionName);
    }

})();


