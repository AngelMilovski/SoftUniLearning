function sumDigits(input) {
    let number = +input;
    let sum = 0;
    while (number > 0) {
        let num = number % 10;
        sum += num;
        number = parseInt(number / 10);
    }
    return sum;
}

const result = sumDigits(543);
console.log(result);