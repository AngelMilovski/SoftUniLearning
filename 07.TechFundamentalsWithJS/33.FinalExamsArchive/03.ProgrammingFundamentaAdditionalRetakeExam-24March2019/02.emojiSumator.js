function emojiSumator(params) {
    let text = params[0];
    let pattern = /(?<= ):[a-z]{4,}:(?=[ ,.!?])/g;
    let matched = text.match(pattern);
    if (matched) {
        let emojiFromCode = params[1]
            .split(':')
            .map(n => String.fromCharCode(n))
            .join('');

        let mapMatched = matched.map(m => m.substring(1, m.length - 1));
        let sum = mapMatched
            .map(m => {
                m = m.split('')
                    .map(e => e.charCodeAt(0))
                    .reduce((acc, cur) => {
                        acc += cur;
                        return acc;
                    }, 0);
                return m;
            })
            .reduce((acc, curr) => {
                acc += curr;
                return acc;
            }, 0);

        if (mapMatched.includes(emojiFromCode)) {
            sum *= 2;
        }

        console.log('Emojis found: ' + matched.join(', '));
        console.log('Total Emoji Power: ' + sum);
    } else {
        console.log('Total Emoji Power: 0');
    }
}

emojiSumator([
    'Hello I am Mark from :England: and I am :one: :seven: years old, I have a :hamster: as pet.',
    '115:101:118:101:110'
]);
emojiSumator([
    'In the Sofia Zoo there are many animals, such as :ti ger:, :elephan:t, :monk3y:, :goriLLa:, :fox:.',
    '97:101:117:114'
]);