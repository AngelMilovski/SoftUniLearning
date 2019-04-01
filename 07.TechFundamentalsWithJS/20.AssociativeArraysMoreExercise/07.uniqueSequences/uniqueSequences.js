function solve(params) {
    let array = [];
    for (const line of params) {
        let arr = JSON.parse(line).map(Number).sort((a, b) => b - a);
        array.push(arr);
    }

    let indexes = [];
    for (let i = 0; i < array.length - 1; i++) {
        let curr = array[i];
        for (let j = i + 1; j < array.length; j++) {
            let isSame = true;
            let next = array[j];
            if (curr.length != next.length) {
                isSame = false;
                continue;
            }
            for (let k = 0; k < array.length; k++) {
                if (curr[k] !== next[k]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame && !indexes.includes(j)) {
                indexes.push(j);
            }
        }
    }

    for (let i = indexes.length - 1; i >= 0; i--) {
        array.splice(indexes[i], 1);
    }

    array
        .sort((a, b) => a.length - b.length)
        .forEach(arr => console.log(`[${arr.join(', ')}]`));
}

solve([
    "[7.14, 7.180, 7.339, 80.099]",
    "[7.339, 80.0990, 7.140000, 7.18]",
    "[7.339, 7.180, 7.14, 80.099]"
]);
solve([
    "[-3, -2, -1, 0, 1, 2, 3, 4]",
    "[10, 1, -17, 0, 2, 13]",
    "[4, -3, 3, -2, 2, -1, 1, 0]"
]);