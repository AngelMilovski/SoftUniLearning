function solve(item, arr) {
    const arrayLength = +item;
    return arr
        .filter((v, i) => {
            if (i < arrayLength) {
                return v;
            }
        })
        .reverse()
        .join(' ');
}

const result = solve(3, ['10', '20', '30', '40', '50']);
console.log(result);