function solve(item) {
    let number = +item;
    let sum = 0;
    let currentNumber = 1;
    while (number > 0) {
        console.log(currentNumber);
        sum += currentNumber;
        currentNumber += 2;
        number -= 1;
    }
    console.log(`Sum: ${sum}`);
}

solve(3);