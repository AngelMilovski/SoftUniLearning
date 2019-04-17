function anonymousVox(params) {
    let input = params[0];
    let values = params[1].split(new RegExp('[{}]', 'g')).filter(e => e !== '');
    let pattern = /([A-Za-z]+)(?<placeholder>.+)\1/g;
    let i = 0;
    let oldPlaceholders = [];
    let placeholders = [];

    while ((match = pattern.exec(input)) !== null) {
        if (values[i]) {
            let newPlaceholder = match[1] + values[i++] + match[1];
            placeholders.push(newPlaceholder);
            oldPlaceholders.push(match[0]);
        }
    }

    while (oldPlaceholders.length) {
        input = input.replace(oldPlaceholders.pop(), placeholders.pop());
    }

    return input;
}

let result = anonymousVox(['Hello_mister,_Hello', '{ Jack }']);
console.log(result);
console.log('---------------');
result = anonymousVox(['ASD___asdfffasd', '{this}{exam}{problem}{is}{boring}']);
console.log(result);
console.log('----------------');
result = anonymousVox(['Whatsup_ddd_sup', '{Dude}']);
console.log(result);
console.log('-----------------');
result = anonymousVox(['HeypalHey______how_ya_how_doin_how', '{first}{second}']);
console.log(result);