function getInfo() {
	const stopID = '#stopId';
    const submit = '#submit';
    const stopNameSelector = '#stopName';
    const busesListSelector = '#buses';

    const selectors = {
        stopID,
        submit,
        stopNameSelector,
        busesListSelector
    };

    const stopName = document.querySelector(selectors.stopNameSelector);
    const busesList = document.querySelector(selectors.busesListSelector);

    const clearBusesList = (list) => {
        list.innerHTML = '';
    };

    const clearInput = (input) => {
        input.value = '';
    };

    const parseResponse = (res) => {
        return res.json();
    };

    const createLi = (bus) => {
        const [busId, timeToArrives] = bus;
        const busInfo = `Bus ${busId} arrives in ${timeToArrives}`;
        const li = document.createElement('li');
        li.textContent = busInfo;
        return li;
    };

    const appendToUl = (busInfo) => {
        busesList.appendChild(busInfo);
        return busesList;
    };

    const displayBusesInfo = (res) => {
        const { name, buses } = res;
        stopName.textContent = name;
        Object
            .entries(buses)
            .map(createLi)
            .forEach(appendToUl);
    };

    const displayError = () => {
        stopName.textContent = 'Error';
    };

    const stopInput = document.querySelector(selectors.stopID);
    const stop = +stopInput.value;

    if (stop) {
        clearInput(stopInput);
        clearBusesList(busesList);
        const url = `https://judgetests.firebaseio.com/businfo/${stop}.json`;
        fetch(url)
            .then(parseResponse)
            .then(displayBusesInfo)
            .catch(displayError);
    }
}

