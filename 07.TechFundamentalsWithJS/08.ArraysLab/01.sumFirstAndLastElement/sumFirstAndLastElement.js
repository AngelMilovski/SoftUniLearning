function solve(arr) {
    const firstNum = +arr.shift();
    const secondNum = +arr.pop();
    return firstNum + secondNum;
}

const result = solve(['10', '17', '22', '33']);

console.log(result);