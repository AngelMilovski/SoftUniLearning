function ladybugs(args) {
    const fieldSize = +args.shift();
    const ladybugsIndexes = args.shift().split(' ');
    let initialField = createArr(fieldSize, ladybugsIndexes);


    for (const line of args) {

        const tokens = line.split(' ');
        const ladybugIndex = +tokens[0];
        if (ladybugIndex < 0 || ladybugIndex > initialField.length - 1 || initialField[ladybugIndex] === 0) {
            continue;
        }
        const command = tokens[1];
        const flyLength = +tokens[2];

        initialField[ladybugIndex] = 0;
        switch (command) {
            case 'left':
                let position = ladybugIndex - flyLength;
                while (position < initialField.length) {

                    if (initialField[position] === 1) {
                        position -= flyLength;
                        continue;
                    }

                    initialField[position] = 1;
                    break;
                }
                break;

            case 'right':
                let index = ladybugIndex + flyLength;
                while (index < initialField.length) {
                    if (initialField[index] === 1) {
                        index += flyLength;
                        continue;
                    }

                    initialField[index] = 1;
                    break;
                }
                break;
        }
    }

    return initialField.join(' ');

    function createArr(size, ladybugsIndexes) {
        let array = [];
        for (let i = 0; i < size; i++) {
            array.push(0);
        }
        array = fillFieldWithLadybugs(array, ladybugsIndexes);
        return array;
    }

    function fillFieldWithLadybugs(arr, indexes) {
        for (let i = 0; i < indexes.length; i++) {
            const index = +indexes[i];
            if (index >= 0 && index < arr.length) {
                arr[index] = 1;
            }
        }
        return arr;
    }
}

const result = ladybugs([
    3, '0 2',
    '0 right -1',
    '2 right -94357321'
]);

console.log(result);