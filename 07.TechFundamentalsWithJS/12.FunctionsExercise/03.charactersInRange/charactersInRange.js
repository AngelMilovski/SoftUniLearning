function charactersInRange(firstChar, secondChar) {
    let getCharactersInRange = function getCharactersInRangeFromCharCode(firstCh, secondCh) {
        let charToNumber = ch => ch.charCodeAt(0);
        const startRang = Math.min(charToNumber(firstCh), charToNumber(secondCh)) + 1;
        const endRange = Math.max(charToNumber(firstCh), charToNumber(secondCh));
        let elements = [];
        for (let i = startRang; i < endRange; i++) {
            const element = String.fromCharCode(i);
            elements.push(element);
        }
        
        return elements.join(' ');
    };

    return getCharactersInRange(firstChar, secondChar);
}

const output = charactersInRange('#', ':');
console.log(output);