function commonElements(firstInput, secondInput) {
    const firstArr = firstInput.slice();
    const secondArr = secondInput.slice();
    let newArr = [];

    if (firstArr.length > secondArr.length) {
        newArr = fillArr(secondArr, firstArr, newArr);
    } else {
        newArr = fillArr(firstArr, secondArr, newArr);
    }

    newArr.forEach(e => console.log(e));

    function fillArr(arr1, arr2, newArr) {
        for (const item of arr1) {
            if (arr2.includes(item)) {
                newArr.push(item);
            }
        }
        return newArr;
    }
}

const result = commonElements(
    ["S", "o", "f", "t", "U", "n", "i", " "],
    ["s", "o", "c", "i", "a", "l"]
);