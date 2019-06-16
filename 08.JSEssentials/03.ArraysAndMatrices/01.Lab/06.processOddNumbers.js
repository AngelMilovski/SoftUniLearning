function solve(params) {
    return params
        .filter((e, i) => i % 2 !== 0)
        .map((e) => {
            let number = +e;
            return number * 2;
        })
        .reverse()
        .join(' ');
}

console.log(solve([10, 15, 20, 25]));