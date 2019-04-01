function rotateArray(args) {
    let array = args.slice();
    const rotateCount = +array.pop() % array.length;

    for (let i = 0; i < rotateCount; i++) {
        const lastElFromOldArr = array[array.length - 1];
        for (let j = array.length - 1; j > 0;  j--) {
            const currentEl = array[j - 1];
            array[j] = currentEl;
        }
        array[0] = lastElFromOldArr;
    }

    return array.join(' ');
}

const result = rotateArray(['1', '2', '3', '4', '2']);
console.log(result);