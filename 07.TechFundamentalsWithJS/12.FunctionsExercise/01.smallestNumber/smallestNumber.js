function smallestNumber(numOne, numTwo, numThree) {
    let numbers = [+numOne, +numTwo, +numThree];
    return Math.min(...numbers);
}

const result = smallestNumber(2, 5, 3);
console.log(result);