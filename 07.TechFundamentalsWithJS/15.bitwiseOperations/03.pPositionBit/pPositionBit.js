function pPositionBit(number, position) {
    number = +number;
    position = +position;
    let shiftedBits = number >> position;
    let result = shiftedBits & 1;
    return result;
}

const output = pPositionBit(255, 7);
console.log(output);

