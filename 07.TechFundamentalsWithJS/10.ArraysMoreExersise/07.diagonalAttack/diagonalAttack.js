function diagonalAttack(args) {
    let matrix = [];
    let sumOfLeftDiagonal = 0;
    let sumOfRightDiagonal = 0;
    for (const index in args) {
        matrix[index] = args[index].split(' ');
    }

    for (let i = 0; i < matrix.length; i++) {
        sumOfLeftDiagonal += +matrix[i][i];
        sumOfRightDiagonal += +matrix[i][matrix.length - 1 - i];
    }
    if (sumOfLeftDiagonal === sumOfRightDiagonal) {
        matrix = fillMatrix(matrix, sumOfLeftDiagonal);
    } 

    for (const item of matrix) {
        console.log(item.join(' '));
    }

    function fillMatrix(matrix, sum) {
        for (let i = 0; i < matrix.length; i++) {
            for (let j = 0; j < matrix.length; j++) {
                
                if (i !== j && ((matrix.length - 1 - i) - (j - 1) !== 1)) {
                    matrix[i][j] = sum;
                }
            }
            
        }
        return matrix;
    }
}

diagonalAttack([
    '5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1'
]);