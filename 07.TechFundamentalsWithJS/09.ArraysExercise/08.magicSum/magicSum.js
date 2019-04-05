function magicSum(args) {
    const array = args[0].split(' ').map(Number);
    const givenNumber = +args[1];
    let pairs = [];
    for (let i = 0; i < array.length - 1; i++) {
        const curr = array[i];
        for (let j = i + 1; j < array.length; j++) {
            const next = array[j];
            if (curr + next === givenNumber) {
                const result = `${curr} ${next}`;
                pairs.push(result);
            }
        }
    }
    pairs.forEach((pairs) => console.log(pairs));
}

magicSum(['1 2 3 4 5 6', '6']);