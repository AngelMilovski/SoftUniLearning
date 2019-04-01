function solve(number) {
    let strArr = number.toString();
    let sum = 0;
    for (let number of strArr) {
        sum += +number;
    }
    let result = sum.toString().includes('9') ? `${number} Amazing? True` : `${number} Amazing? False`;
    console.log(result);
}

solve(1233);
solve(999);