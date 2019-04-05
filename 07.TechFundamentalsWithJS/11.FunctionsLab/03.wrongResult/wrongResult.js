function wrongResult(firstInput, secondInput, thirdInput) {
    let numOne = +firstInput,
        numTwo = +secondInput,
        numThree = +thirdInput;


    if (isPositive(numOne) && isPositive(numTwo) && isPositive(numThree) ||
        // !isPositive(numOne) && isPositive(numTwo) && !isPositive(numThree) ||
        isPositive(numOne) && !isPositive(numTwo) && !isPositive(numThree) ||
        // !isPositive(numOne) && !isPositive(numTwo) && isPositive(numThree) ||
        !isPositive(numOne) && isPositive(numTwo) && isPositive(numThree)) 
        {
        return 'Positive';
    } else {
        return 'Negative';
    }

    function isPositive(num) {
        if (num >= 0) {
            return true;
        }
        return false;
    }
}

console.log(wrongResult(5, 12, -15));
console.log(wrongResult(-6, 12, -14));
console.log(wrongResult(-1, -2, -3));
console.log(wrongResult(-1, 0, 1));