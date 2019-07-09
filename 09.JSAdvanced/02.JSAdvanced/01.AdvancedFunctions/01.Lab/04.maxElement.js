function maxElement(params) {
    return Math.max.apply(null, params);
}

const result = maxElement([1, 44, 123, 33]);
console.log(result);