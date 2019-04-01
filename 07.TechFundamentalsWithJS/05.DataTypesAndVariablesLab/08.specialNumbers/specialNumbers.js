function specialNumbers(input) {
    let number = +input;
    for (let i = 1; i <= number; i++) {
        let sum = 0;
        let num = i;
        while (num > 0) {
            let lastDigit = num % 10;
            sum += lastDigit;
            num = parseInt(num / 10);
        }
        if (sum === 5 || sum === 7 || sum === 11) {
            console.log(i + ' -> ' + 'True');
        } else {
            console.log(i + ' -> ' + 'False');
        }
    }
}

specialNumbers(15);