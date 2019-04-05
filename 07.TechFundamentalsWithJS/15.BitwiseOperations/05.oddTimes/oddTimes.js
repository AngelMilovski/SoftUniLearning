function oddTimes(params) {
    let array = params.split(' ').map(Number);

    let result = 0;
    for (let i = 0; i < array.length; i++) {
        result = result ^ array[i];
    }

    return result;
}

const output = oddTimes('5 7 2 7 5 2 5');
console.log(output);