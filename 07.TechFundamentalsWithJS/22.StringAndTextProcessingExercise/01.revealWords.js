function revealWords(searchedWords, text) {
    let arrOfSearchedWords = searchedWords.split(', ');
    for (const word of arrOfSearchedWords) {
        let pattern = '*'.repeat(word.length);
        text = text.replace(pattern, word);
    }

    return text;
}

let result = revealWords('great', 'softuni is ***** place for learning new programming languages');
console.log(result);
result = revealWords('great, learning', 'softuni is ***** place for ******** new programming languages');
console.log(result);