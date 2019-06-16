function biggestElement(params) {
    return Math.max.apply(null, params
        .reduce((acc, cur) => {
            acc.push(Math.max(...cur));
            return acc;
        }, []));
}

console.log(biggestElement([
    [20, 50, 10],
    [8, 33, 145]
]));