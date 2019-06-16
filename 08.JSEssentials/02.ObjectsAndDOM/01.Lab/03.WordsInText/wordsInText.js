function wordsInText(params) {
    let words = {};
    let matched = params[0].match(/\w+/g);
    if (matched) {
        for (const word of matched) {
            if (!words[word]) {
                words[word] = 0;
            }
            words[word] += 1;
        }
    }

    return JSON.stringify(words);
}

wordsInText(["JS devs use Node.js for server-side JS.-- JS for devs"]);