function findSubstrings(text, searchedWord) {
    let stringText = text.toLowerCase();
    let word = searchedWord.toLowerCase();
    let count = 0;
    let startIndex = 0;
    let index = stringText.indexOf(word, startIndex);
    while (index > -1) {
        count += 1;
        startIndex = index + 1;
        index = stringText.indexOf(word, startIndex);
    }

    return count;
}

const result = findSubstrings("Welcome to the Software University (SoftUni)! Welcome to programming. Programming is wellness for developers, said Maxwell.", "wel");
console.log(result);