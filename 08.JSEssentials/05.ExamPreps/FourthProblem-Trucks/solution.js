function solve() {
    let btns = document.querySelectorAll('button');
    [...btns].forEach(btn => btn.addEventListener('click', callback));
    let tires = [];
    let trucks = {};
    let divForTruck = document.querySelector('#exercise > section:nth-child(2) > fieldset:nth-child(2) > div');
    let tiresSets = document.querySelector('#exercise > section:nth-child(2) > fieldset:nth-child(1) > div');

    function callback(evt) {
        let btn = evt.target;
        switch (btn.textContent) {
            case 'Add new truck':
                addTruck();
                break;

            case 'Add new tires':
                addNewTires();
                break;

            case 'Go to work':
                travel();
                break;

            case 'End of the shift':
                getInformation();
                break;
        }
    }

    function addTruck() {
        let plateNumber = document.querySelector('#newTruckPlateNumber');
        let tiresConditioning = document.querySelector('#newTruckTiresCondition');
        if (plateNumber.value && tiresConditioning.value && (tiresConditioning.value).split(' ').length === 8) {
            if (!trucks.hasOwnProperty(plateNumber.value)) {
                trucks[plateNumber.value] = {
                    travel: 0,
                    tires: tiresConditioning.value
                };
                let divTruck = document.createElement('div');
                divTruck.setAttribute('class', 'truck');
                divTruck.textContent = plateNumber.value;
                divForTruck.appendChild(divTruck);
                plateNumber.value = '';
                tiresConditioning.value = '';
            }
        }
    }

    function addNewTires() {
        let newTiresCondition = document.querySelector('#newTiresCondition');
        if (newTiresCondition.value && (newTiresCondition.value).split(' ').length === 8) {
            tires.push(newTiresCondition.value);
            let tiresDiv = document.createElement('div');
            tiresDiv.setAttribute('class', 'tireSet');
            tiresDiv.textContent = newTiresCondition.value;
            tiresSets.appendChild(tiresDiv);
            newTiresCondition.value = '';
        }
    }

    function travel() {
        let number = document.querySelector('#workPlateNumber').value;
        let distance = +document.querySelector('#distance').value;
        let tiresArr = [];
        if (number && distance) {
            if (trucks[number]) {
                tiresArr = setTires(trucks[number].tires);
                if (checkTires(tiresArr, distance)) {
                    trucks[number].tires = changeTiresConditioning(tiresArr, distance);
                    addDistance(number, distance);
                } else {
                    if (tires.length > 0) {
                        trucks[number].tires = tires.shift();
                        tiresSets.removeChild(tiresSets.firstChild);
                        tiresArr = setTires(trucks[number].tires);
                        if (checkTires(tiresArr, distance)) {
                            trucks[number].tires = changeTiresConditioning(tiresArr, distance);
                            addDistance(number, distance);
                        }
                    }
                }
                document.querySelector('#workPlateNumber').value = '';
                document.querySelector('#distance').value = '';
            }
        }
    }

    function getInformation() {
        let result = '';
        Object
            .keys(trucks)
            .forEach((t) => {
                result += `Truck ${t} has traveled ${trucks[t].travel}.\n`;
            });
        result += `You have ${tires.length} sets of tires left.\n`;
        document.querySelector('textarea').textContent = result;
    }

    function setTires(tires) {
        return tires.split(' ').map(Number);
    }

    function checkTires(tires, distance) {
        return tires.every(t => t - parseInt(distance / 1000) >= 0);
    }

    function changeTiresConditioning(tires, distance) {
        return tires
            .map(t => t - parseInt(distance / 1000))
            .join(' ');
    }

    function addDistance(number, distance) {
        trucks[number].travel += distance;
    }
}