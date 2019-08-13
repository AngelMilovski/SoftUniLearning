function solve() {
    const infoSel = '#info .info';
    const departBtnSel = '#depart';
    const arriveBtnSel = '#arrive';
    const selectors = { infoSel, departBtnSel, arriveBtnSel };
    const info = document.querySelector(selectors.infoSel);
    const departBtn = document.querySelector(selectors.departBtnSel);
    const arriveBtn = document.querySelector(selectors.arriveBtnSel);

    let stopId = 'depot';
    let stopName = 'Depot';


    function depart() {
        disableBtn(departBtn, arriveBtn);
        const url = `https://judgetests.firebaseio.com/schedule/${stopId}.json`;
        fetch(url)
            .then(parseResponse)
            .then(displayInfo)
            .catch(displayError);
    }

    function arrive() {
        disableBtn(arriveBtn, departBtn);
        const stopInfo = {
            name: stopName,
            next: stopId
        };

        displayInfo(stopInfo);
    }

    function displayInfo(stopInfo) {
        const { name, next } = stopInfo;
        stopId = next;
        stopName = name;
        let result = `Next stop ${stopName}`;
        if (arriveBtn.disabled) {
            result = `Arriving at ${stopName}`;
        }
        
        info.textContent = result;
    }

    function displayError() {
        disableBtns();
        info.textContent = 'Error';
    }

    function disableBtns() {
        departBtn.disabled = true;
        arriveBtn.disabled = true;
    }

    function disableBtn(disable, enable) {
        disable.disabled = true;
        enableBtn(enable);
    }

    function enableBtn(btn) {
        btn.disabled = false;
    }

    function parseResponse(res) {
        return res.json();
    }


    return {
        depart,
        arrive
    };
}

const result = solve();