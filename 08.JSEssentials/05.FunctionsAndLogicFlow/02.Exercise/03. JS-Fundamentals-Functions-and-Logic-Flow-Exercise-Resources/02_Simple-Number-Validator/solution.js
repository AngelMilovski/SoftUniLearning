function validate() {
    let input = document.querySelector('input');
    let btn = document.querySelector('button');
    btn.addEventListener('click', checkInput);

    function checkInput() {
        let row = input.value;
        if (row) {
            let output = checkRowIsValid(row);
            document.querySelector('#response').textContent = output ?
                'This number is Valid!' :
                'This number is NOT Valid!';
        }
    }

    function checkRowIsValid(row) {
        if ((/^\d{10}$/).test(row)) {
            const weightOfNumbers = [2, 4, 8, 5, 10, 9, 7, 3, 6];
            let numbers = row.split('').map(Number);
            let numberForCheck = +numbers.pop();
            let sum = numbers.reduce((acc, cur, inx) => {
                acc += cur * weightOfNumbers[inx];
                return acc;
            }, 0);

            let remainder = (sum % 11 !== 10) ?
                sum % 11 :
                0;
            return numberForCheck === remainder;
        }

        return false;
    }
}