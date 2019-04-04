function countStringOccurrences(text, searchedWord) {
    let wordsArray = text.split(' ').filter(w => w === searchedWord);
    return wordsArray.length;
}

const result = countStringOccurrences("This is a word and it also is a sentence", "is");
console.log(result);