function shortestAndLongestWord(text) {
    const pattern = /[[\]!?+\s'',"".;:\-_/#$%^&*()+=|\\/><~`]/g;
    const words = text.split(pattern).filter(e => e !== '');
    const getTheShortestWord = function checkForTheSmallestWord(words) {
        let theShortestWord = '';
        for (let i = 0; i < words.length; i++) {
            const currentWord = words[i];
            if (i == 0) {
                theShortestWord = currentWord;
            }

            if (currentWord.length < theShortestWord.length) {
                theShortestWord = currentWord;
            }
        }
        return theShortestWord;
    };

    const getTheLongestWord = function checkForTheLongestWord(words) {
        let theLongestWord = '';
        for (const word of words) {
            if (word.length > theLongestWord.length) {
                theLongestWord = word;
            }
        }

        return theLongestWord;
    };

    const theLongestWord = getTheLongestWord(words);
    const theShortestWord = getTheShortestWord(words);

    console.log('Longest -> ' + theLongestWord);
    console.log('Shortest -> ' + theShortestWord);
}

shortestAndLongestWord('Lorem Ipsum is simply dummy text of the printing and typesetting industry.');