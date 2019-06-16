function solve(params) {
    params.reduce((acc, cur) => {
        if (cur < 0) {
            acc.unshift(cur);
        } else {
            acc.push(cur);
        }

        return acc;
    }, [])
    .forEach(arr => console.log(arr));
}

solve([3, -2, 0, -1]);