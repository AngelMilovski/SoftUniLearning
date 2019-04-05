function calculator(firstItem, secondItem, thirdItem) {
    let firstNum = +firstItem,
        operator = secondItem,
        secondNum = +thirdItem;
    const accumulation = function accumulationTwoNumbers(a, b) {
        return a + b;
    };

    const subtraction = function subtractionTwoNumbers(a, b) {
        return a - b;
    };

    const multiplication = function multiplicationTwoNumbers(a, b) {
        return a * b;
    };

    const division = function divisionTwoNumbers(a, b) {
            return a / b;
    };

    const modulo = function moduleDivisionTwoNumbers(a, b) {

        return a % b;

    };

    const exponentiation = function (a, b) {
        return Math.pow(a, b);
    };

    switch (operator) {
        case '+':
            return accumulation(firstNum, secondNum).toFixed(2);
        case '-':
            return subtraction(firstNum, secondNum).toFixed(2);
        case '*':
            return multiplication(firstNum, secondNum).toFixed(2);
        case '/':
            return division(firstNum, secondNum).toFixed(2);
        case '%':
            return modulo(firstNum, secondNum).toFixed(2);
        case '^':
            return exponentiation(firstNum, secondNum).toFixed(2);
    }
}

const result = calculator(4, '/', 2);
console.log(result);