function leapYear() {
    let input = document.querySelector('input');
    let btn = document.querySelector('button');
    btn.addEventListener('click', clickEvent);
    let resultMessage = document.querySelector('#year h2');
    let outputYear = document.querySelector('#year div');

    function clickEvent() {
        if (input) {
            let year = +input.value;
            if (year % 4 === 0 || (year % 100 === 0 && year % 400 === 0)) {
                resultMessage.textContent = 'Leap Year';
            } else {
                resultMessage.textContent = 'Not Leap Year';
            }
            outputYear.textContent = year;
            input.value = '';
        }
    }
}