function dictionary(params) {
    let data = params[0].split(' | ');
    let searchedWords = params[1].split(' | ');
    let command = params[2];

    let words = {};
    for (const wordData of data) {
        let [word, definition] = wordData.split(': ');
        if (!words.hasOwnProperty(word)) {
            words[word] = [];
        } 
        words[word].push(definition);
    }

    if (command === 'End') {
        let objWithSearchedWords = {};
        // for (const test of searchedWords) {
        //     if (words.hasOwnProperty(test)) {
        //         newObj[test] = words[test];
        //     }
        // }
        searchedWords.forEach(function(word){
            if (words.hasOwnProperty(word)) {
                objWithSearchedWords[word] = words[word];
            }
        });
        Object
            .keys(objWithSearchedWords)
            .forEach((key) => {
                console.log(key);
                objWithSearchedWords[key]
                    .sort((a, b) => b.length - a.length)
                    .forEach((d) => {
                    console.log(' -' + d);
                });
            });
    } else if (command === 'List') {
        console.log(Object
            .keys(words)
            .sort((a, b) => a.localeCompare(b))
            .join(' '));
    }
}

dictionary([
    'programmer: an animal, which turns coffee into code | developer: a magician',
    'Pesho | Gosho',
    'List'
]);