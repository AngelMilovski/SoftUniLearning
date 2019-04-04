function bitDestroyer(number, position) {
    number = +number;
    position = +position;
    let mask = ~(1 << position);
    let result = mask & number;
    return result;
}

const output = bitDestroyer(1313, 5);
console.log(output);