function snowWhite(input, inputArray) {
    String.prototype.splice = function (startIndex, count, newItem) {
        let target = this;
        newItem = (newItem !== undefined) ? (newItem + ' ') : '';
        let firstPart = target.slice(0, startIndex);
        let secondPart = target.slice(startIndex + Math.abs(count));
        let str = firstPart + newItem;
        str += secondPart;
        return str.replace('  ', ' ');
    };

    let text = input;
    let arrayOfNames = inputArray.slice();
    const pattern = /\bdwarf\b/g;
    const keyWordLength = 5;
    let match = pattern.exec(text);
    while (match != null) {
        if (arrayOfNames.length > 0) {
            text = text.splice((match.index + keyWordLength) + 1, 0, arrayOfNames.splice(0, 1)[0]);
        } else {
            text = text.splice(match.index, keyWordLength);
        }
        match = pattern.exec(text);
    }

    return text;
}

const result = snowWhite(
    "Yet another dwarf fairytale tragedy! There are dwarf so many dwarfs, is it dwarf possible to help dwarf Show white?",
    ["Doc", "Dopey", "Sleepy"]   
);
console.log(result);