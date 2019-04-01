function binaryDigitsCount(number, bitToFind) {
    number = +number;
    bitToFind = +bitToFind;
    let binaryToStr = (number).toString(2);
    
    let count = 0;
    for (let i = 0; i < binaryToStr.length; i++) {
        let bit = +binaryToStr[i];
        if (bit == bitToFind) {
            count += 1;
        }
    }

    console.log(count);
}

binaryDigitsCount(10, 0);