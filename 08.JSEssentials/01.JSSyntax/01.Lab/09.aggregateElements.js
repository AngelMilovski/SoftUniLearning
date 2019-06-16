function aggregateElements(params) {
    let aggregate = function(array, initialVal, func) {
        let val = initialVal;
        for (let i = 0; i < array.length; i++) {
            const element = array[i];
            val = func(val, element);
        }
        console.log(val);
    };

    let arr = params.map(Number);
    aggregate(arr, 0, (a, b) => a + b);
    aggregate(arr, 0, (a, b) => a + 1 / b);
    aggregate(arr, '', (a, b) => a + b);
}

aggregateElements([2, 4, 8, 16]);