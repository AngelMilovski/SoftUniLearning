function distinctArray(array) {
    return array.filter((e, i) => array.indexOf(e) === i).join(' ');
}

const output = distinctArray([20, 8, 12, 13, 4, 4, 8, 5]);
console.log(output);