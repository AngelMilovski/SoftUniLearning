function rounding(firsItem, secondItem) {
    const maxPrecision = 15;
    let number = +firsItem;
    let precision = +secondItem;

    precision = (precision > maxPrecision) ? maxPrecision : precision;
    return (+number.toFixed(precision));
}

const result = rounding(3.1415926535897932384626433832795,2);
console.log(result);