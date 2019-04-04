function factorialDivision(numOne, numTwo) {
    let factorial = function getFactorial(num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    };

    numOne = +numOne;
    numTwo = +numTwo; 

    let firstSum = factorial(numOne);
    let secondSum = factorial(numTwo);

    return (firstSum / secondSum).toFixed(2);
}

const output = factorialDivision(5, 2);
console.log(output);