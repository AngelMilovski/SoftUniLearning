function magicMatrices(args) {
    let matrix = args.slice();
    let currSum;
    for (let i = 0; i < matrix.length; i++) {
        let rowSum = 0;
        let colSum = 0;
        for (let j = 0; j < matrix.length; j++) {
            const elFormRow = +matrix[j][i];
            const elFromCol = +matrix[i][j];
            rowSum += elFormRow;
            colSum += elFromCol;
        }
        if (i === 0) {
            currSum = rowSum;
        }
        if (rowSum !== colSum || rowSum !== currSum) {
            return false;
        }
    }
    return true;
}

const result = magicMatrices([
    [3, 2, 5],
    [2, 3, 4],
    [5, 4, 0]
]);

console.log(result);