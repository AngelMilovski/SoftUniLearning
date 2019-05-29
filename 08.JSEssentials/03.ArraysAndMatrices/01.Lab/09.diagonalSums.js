function diagonalSums(params) {
    let primaryDiagonalSum = params
        .map((e, i) => e[i])
        .reduce((acc, cur) => acc + cur, 0);
    let secondaryDiagonalSum = params
        .map((e, i) => {
            let index = params.length - 1 - i;
            return e[index];
        })
        .reduce((acc, cur) => acc + cur, 0);

    console.log(primaryDiagonalSum + ' ' +  secondaryDiagonalSum);
}

diagonalSums([
    [20, 40],
    [10, 60]
]);