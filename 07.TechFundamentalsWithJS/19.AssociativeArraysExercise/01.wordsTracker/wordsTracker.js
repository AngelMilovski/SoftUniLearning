function solve(arr) {
    const searchedString = arr.shift().split(' ');
    let occurrences = searchedString.reduce((acc, curr) => {
        acc[curr] = 0;
        return acc;
    }, {});

    for (let string of arr) {
        if (searchedString.includes(string)) {
            occurrences[string] += 1;
        }
    }

    Object
        .keys(occurrences)
        .sort((a, b) => occurrences[b] - occurrences[a])
        .forEach(key => console.log(`${key} - ${occurrences[key]}`));
}

solve([
    'this sentence',
    'In', 'this',
    'sentence', 'you', 'have',
    'to', 'count',
    'the',
    'occurances',
    'of',
    'the',
    'words',
    'this',
    'and',
    'sentence',
    'because',
    'this',
    'is',
    'your',
    'task'
]);