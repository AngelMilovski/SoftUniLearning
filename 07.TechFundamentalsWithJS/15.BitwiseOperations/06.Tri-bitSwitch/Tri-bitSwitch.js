function solve(number, position) {
    number = +number;
    position = +position;
    let mask = 7 << position;
    let result = number ^ mask;
    return result;
}

const output = solve(41, 0);
console.log(output);