function solve(firstItem, secondItem, thirdItem) {
    let [firstNumber, secondNumber, thirdNumber] = [+firstItem, +secondItem, +thirdItem];
    let sum = firstNumber + secondNumber + thirdNumber;
    console.log((sum % 1 === 0) ? `${sum} - Integer` : `${sum} - Float`);
}

solve(9, 100, 1.1);
solve(100, 200, 303);
