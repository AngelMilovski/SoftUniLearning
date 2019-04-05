function firstBit(number) {
    number = +number;
    let shiftedBits = number >> 1;
    let result = shiftedBits & 1;
    return result;
}

const output = firstBit(24);
console.log(output);