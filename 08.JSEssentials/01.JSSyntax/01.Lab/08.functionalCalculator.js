function solve(firstArg, secondArg, thirdArg) {
    let add = function (num1, num2) {
        return num1 + num2;
    };

    let subtract = function (num1, num2) {
        return num1 - num2;
    };

    let multiply = function (num1, num2) {
        return num1 * num2;
    };

    let divide = function (num1, num2) {
        if (num2 !== 0) {
            return num1 / num2;
        }

        return '';
    };

    let num1 = +firstArg;
    let num2 = +secondArg;
    switch (thirdArg) {
        case '+': return add(num1, num2);
        case '-': return subtract(num1, num2);
        case '*': return multiply(num1, num2);
        case '/': return divide(num1, num2);
    }
}

console.log(solve(18, -1, '*'));