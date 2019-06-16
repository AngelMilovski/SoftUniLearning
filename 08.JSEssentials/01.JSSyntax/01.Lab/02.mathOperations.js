function mathOperations(num1, num2, operator) {
    num1 = +num1;
    num2 = +num2;
    let sum = 0;
    switch (operator) {
        case '+':
            sum = num1 + num2;
            break;

        case '-':
            sum = num1 - num2;
            break;

        case '/':
            if (num2 !== 0) {
                sum = num1 / num2;
            }
            break;

        case '%':
            if (num2 !== 0) {
                sum = num1 % num2;
            }
            break;

        case '*':
            sum = num1 * num2;
            break;

        case '**':
            sum = num1 ** num2;
            break;
    }

    return sum;
}

console.log(mathOperations('4', '2', '**'));