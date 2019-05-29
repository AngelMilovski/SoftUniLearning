function equalNeighbors(params) {
    let count = 0;
    params
        .forEach((row, i) => {
            row.forEach((col, j) => {
                if (j < params[i].length - 1) {
                    if (params[i][j + 1] === col) {
                        count += 1;
                    }
                }
                if (i < params.length - 1) {
                    if (params[i + 1][j] === col) {
                        count += 1;
                    }
                }
            });
        });

    console.log(count);
}

equalNeighbors([
    ['2', '2', '5', '7', '4'],
    ['4', '0', '5', '3', '4'],
    ['2', '5', '5', '4', '2']
]);