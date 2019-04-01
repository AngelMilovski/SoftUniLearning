function sumEvenNumbers(arr) {
    return arr
        .map(Number)
        .filter((v) => {
            return v % 2 === 0;
        })
        .reduce((acc, curr) => {
            acc += curr;
            return acc;
        }, 0);
}

const result = sumEvenNumbers(['3','5','7','9']);
console.log(result);