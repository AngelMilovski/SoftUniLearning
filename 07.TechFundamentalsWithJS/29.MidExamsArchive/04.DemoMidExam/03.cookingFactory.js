function solve(array) {
    array.pop();

    let batches = array.map((e) => e.split('#').map(Number)).sort(sortBatch);
    let bestBatches = batches[0];

    console.log('Best Batch quality: ' + getSum(bestBatches));
    console.log(bestBatches.join(' '));

    function sortBatch(a, b) {
        let aSum = getSum(a);
        let bSum = getSum(b);
        let result = bSum - aSum;
        if (result === 0) {
            result = (bSum / b.length) - (aSum /a.length);
            if (result === 0) {
                result = a.length - b.length;
            }
        }
        return result;
    }

    function getSum(arr) {
        return arr.reduce((p, c) => p += c, 0);
    }
}

solve([
    '5#3#2',
    '5#3#2',
    '10',
    '10',
    'Bake It!',
]);