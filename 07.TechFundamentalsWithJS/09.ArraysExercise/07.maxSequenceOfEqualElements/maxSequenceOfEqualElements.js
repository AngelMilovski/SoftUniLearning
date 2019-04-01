function solve(input) {
    const array = input[0].split(' ').map(Number);
    let number = 0;
    let count = 1;
    let maxSequence = 0;
    for (let i = 1; i < array.length; i++) {
        const curr = array[i];
        const prev = array[i - 1];
        if (curr === prev) {
            count += 1;
            if (count > maxSequence) {
                maxSequence = count;
                number = curr;
            }
        } else {
            count = 1;
        }
    }

    let newArr = [];
    for (let i = 0; i < maxSequence; i++) {
        newArr.push(number);
    }

    return newArr.join(' ');
}

const result = solve(['1 1 1 3 3 3 1 3']);
console.log(result);