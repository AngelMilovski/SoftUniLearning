function addAndSubtract(numOne, numTwo, numThree) {
    numOne = +numOne;
    numTwo = +numTwo;
    numThree = +numThree;
    let sum = (a, b) => a + b;
    const result = sum(numOne, numTwo) - numThree;
    return result;
}

const output = addAndSubtract(23, 6, 10);
console.log(output);