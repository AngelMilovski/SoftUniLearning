function orbit(args) {
    const rows = +args[0];
    const cols = +args[1];
    const startRow = +args[2];
    const startCol = +args[3];
    let matrix = [];
    for (let i = 0; i < rows; i++) {
        matrix.push([]);
    }

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            const row = Math.abs(i - startRow);
            const col = Math.abs(j - startCol);
            const element = Math.max(row, col) + 1;
            matrix[i][j] = element;
        }
    }

    return matrix.map(x => x.join(' ')).join('\n');
}

const result = orbit([5, 5, 2, 2]);
console.log(result);