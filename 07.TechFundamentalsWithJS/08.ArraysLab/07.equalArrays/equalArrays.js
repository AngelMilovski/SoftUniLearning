function equalsArrays(arr1, arr2) {
    let array1 = arr1.map(Number);
    let array2 = arr2.map(Number);

    for (let i = 0; i < array1.length; i++) {
        const currentElFromArray1 = array1[i];
        const currentElFromArray2 = array2[i];
        if (currentElFromArray1 !== currentElFromArray2) {
            return `Arrays are not identical. Found difference at ${i} index`;
        }
    }
    const sum = array1.reduce((acc, curr) => {
        acc += curr;
        return acc;
    }, 0);

    return `Arrays are identical. Sum: ${sum}`;
}

const result = equalsArrays(['1'], ['10']);
console.log(result);