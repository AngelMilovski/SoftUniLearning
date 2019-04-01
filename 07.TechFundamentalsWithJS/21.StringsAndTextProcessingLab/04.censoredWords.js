function censoredWords(text, word) {
    let searched = word;
    let replacement = '*'.repeat(searched.length);
    String.prototype.replaceAll = function(searched, replacement) {
        let target = this;
        return target.replace(new RegExp(searched, 'g'), replacement);
    };

    return text.replaceAll(searched, replacement);
}

const result = censoredWords("A small sentence small some words", "small");
console.log(result);