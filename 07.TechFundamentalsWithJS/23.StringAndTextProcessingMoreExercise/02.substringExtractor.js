function substringExtractor(searchedWord, inputText) {
    let word = searchedWord.toLowerCase();
    inputText
        .split(' ')
        .filter(w => !w.toLowerCase().includes(word.toLowerCase()))
        .forEach((currentWord, index) => {
            console.log(`idx[${index}] -> ${currentWord}`);
        });
}

substringExtractor('wel','Welcome to the Software University!');