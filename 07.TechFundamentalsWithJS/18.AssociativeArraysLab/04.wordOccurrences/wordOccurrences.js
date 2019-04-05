function solve(arr) {
    let wordAndTheirCount = {};
    for (let string of arr) {
        if (!wordAndTheirCount.hasOwnProperty(string)) {
            wordAndTheirCount[string] = 0;
        }
        wordAndTheirCount[string] += 1;
    }
    Object
        .entries(wordAndTheirCount)
        .sort((a, b) => b[1] - a[1])
        .forEach((item) => {
            console.log(`${item[0]} -> ${item[1]} times`);
        });
}

solve(["Here", "is", "the", "first", "sentence", "Here", "is", "another", "sentence", "And", "finally", "the", "third", "sentence"]);