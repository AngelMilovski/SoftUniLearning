function bombNumber(sequenceOfNumber, args) {
    let bombNumber = +args[0],
        bombPower = +args[1];

   
    let indexOfBombNumber = sequenceOfNumber.indexOf(bombNumber);
    while (indexOfBombNumber >= 0) {
        sequenceOfNumber.splice(indexOfBombNumber + 1, bombPower);
        let startIndexFromLeftToBomb = Math.max(0, indexOfBombNumber - bombPower);
        let detonationCountFromLeftToCount = Math.min(indexOfBombNumber, bombPower) + 1;
        sequenceOfNumber.splice(startIndexFromLeftToBomb, detonationCountFromLeftToCount);
        indexOfBombNumber = sequenceOfNumber.indexOf(bombNumber);
    }

    let sum = sequenceOfNumber.reduce((acc, curr) => acc + curr, 0);
    return sum;
}

const output = bombNumber(
    [1, 1, 4, 1, 1, 1, 4, 1, 4, 1, 4],
    [4, 1]
);

console.log(output);