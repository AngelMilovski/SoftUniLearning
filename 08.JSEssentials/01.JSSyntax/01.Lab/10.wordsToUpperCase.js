function wordsToUpperCase(params) {
    let matched = params.match(/\w+/g);
    if (matched) {
        return matched.map(w => w.toUpperCase()).join(', ');
    }
}

console.log(wordsToUpperCase('Hi, how are you?'));