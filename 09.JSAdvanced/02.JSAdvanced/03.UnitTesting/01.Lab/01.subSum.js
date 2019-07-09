function subSum(arr, startIndex, endIndex) {
    if (!Array.isArray(arr)) {
        return NaN;
    } else if (startIndex < 0) {
        startIndex = 0;
    } else if (endIndex > arr.length - 1) {
        endIndex = arr.length - 1;
    }

    return arr
        .filter((e, i) => i >= startIndex && i <= endIndex)
        .map(Number)
        .reduce((acc, cur) => acc + cur, 0);
}

console.log(subSum('text', 0, 2));