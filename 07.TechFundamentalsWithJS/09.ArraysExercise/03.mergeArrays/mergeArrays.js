function mergeArrays(firstArr, secondArr) {
    return firstArr
    .reduce((acc, currEl, index) => {
        if (index % 2 != 0) {
            const concatenation = currEl + secondArr[index];
            acc.push(concatenation);
            return acc;
        } else {
            const add = +currEl + (+secondArr[index]);
            acc.push(add);
            return acc;
        }
    }, [])
    .join(' - ');
}

const result = mergeArrays(
    ["5", "15", "23", "56", "35"],
    ["17", "22", "87", "36", "11"]);
console.log(result);