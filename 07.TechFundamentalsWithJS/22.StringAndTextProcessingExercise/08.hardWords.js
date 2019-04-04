function hardWords(params) {
    let text = params[0];
    let wordArray = params[1];
    for (const word of wordArray) {
        let pattern = '_'.repeat(word.length);
        let regex = new RegExp(`\\b${pattern}\\b`, 'g');
        text = text.replace(regex, word);
    }

    return text;
}

const result = hardWords(['Hi, grandma! I\'m so ____ to write to you. ______ the winter vacation, so _______ things happened. My dad bought me a sled. Mom started a new job as a __________. My brother\'s ankle is ________, and now it bothers me even more. Every night Mom cooks ___ on your recipe because it is the most delicious. I hope this year Santa will _____ me a robot.',
['pie', 'bring', 'glad', 'During', 'amazing', 'pharmacist', 'sprained']]);
console.log(result);