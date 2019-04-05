function searchForANumber(params, args) {
    let array = params.slice();
    let [countForTake, countForDelete, searchNumber] = args;
    let newArray = array.splice(0, countForTake);
    newArray.splice(0, countForDelete);
    newArray = newArray.filter(e => e === searchNumber);
    return `Number ${searchNumber} occurs ${newArray.length} time.`;
}

const output = searchForANumber(
    [5, 2, 3, 4, 1, 6],
    [5, 2, 3]
);

console.log(output);