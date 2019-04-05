function spiralMatrix(item1, item2) {
    const row = +item1;
    const col = +item2;
    let matrix = fillMatrix(row, col);
    let number = 0;
    
     let startRow = 0;
     let endRow = row;
     let startCol = 0;
     let endCol = row;

    while (startRow < endRow && startCol < endCol) {

        for (let i = startCol; i < endCol; i++) {
            number += 1;
            matrix[startRow][i] = number;
        }
        startRow += 1;

        for (let i = startRow; i < endRow; i++) {
            number += 1;
            matrix[i][endCol - 1] = number;
        }
        endCol -= 1;

        for (let i = endCol - 1; i >= startCol; i--) {
            number += 1;
            matrix[endRow - 1][i] = number;
        }
        endRow -= 1;

        for (let i = endRow - 1; i >= startRow; i--) {
            number += 1;
            matrix[i][startCol] = number;
        }
        startCol += 1;
    }

    function fillMatrix(row, col) {
        let matrix = [];
        for (let i = 0; i < row; i++) {
            let flatArr = [];
            for (let j = 0; j < col; j++) {
                flatArr.push(0);
            }
            matrix.push(flatArr);
        }
        return matrix;
    }
    for (const item of matrix) {
        console.log(item.join(' '));
    }
}

const result = spiralMatrix(3, 3);
console.log(result);