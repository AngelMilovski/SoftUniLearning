function solve() {
    let seatSectorsCost = {
        Levski: {
            A: 10,
            B: 7,
            C: 5
        },
        Litex: {
            A: 10,
            B: 7,
            C: 5
        },
        VIP: {
            A: 25,
            B: 15,
            C: 10
        }
    };

    let btns = document.querySelectorAll('button');
    [...btns].forEach(btn => btn.addEventListener('click', callback));
    let fansCount = 0;
    let sum = 0;

    function callback(evt) {
        let btn = evt.target;
        let className = btn.getAttribute('class');
        if (className) {
            checkSeats(btn, className);
        } else {
            summary();
        }
    }

    function checkSeats(btn, className) {
        let sectors = ['A', 'B', 'C'];
        let seatNumber = btn.textContent;
        let zone = btn.parentNode.parentNode.parentNode.parentNode.parentNode.getAttribute('class');
        let sector = sectors[btn.parentNode.cellIndex];
        let message = document.querySelector('#output');

        if (className === 'seat') {
            fansCount += 1;
            sum += seatSectorsCost[zone][sector];
            btn.setAttribute('class', 'takenSeat');
            message.textContent += (` Seat ${seatNumber} in zone ${zone} sector ${sector} was taken.\n`);
        } else if (className === 'takenSeat') {
            message.textContent += (` Seat ${seatNumber} in zone ${zone} sector ${sector} is unavailable.\n`);
        }
    }

    function summary() {
        document.querySelector('#summary span').textContent = `${sum} leva, ${fansCount} fans.`;
    }
}