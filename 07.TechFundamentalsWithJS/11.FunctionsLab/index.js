function ladybugs(args) {
    const fieldSize = +args.shift();
    const ladybugsIndexes = args.shift().split(' ');
    let initialField = createArr(fieldSize, ladybugsIndexes);


    for (const line of args) {
        const tokens = line.split(' ');
        let index = +tokens[0];
        const direction = tokens[1];
        const flyLength = +tokens[2];

        if (initialField[index] === 1) {
            initialField[index] = 0;

            while (index >= 0 && index < initialField.length) {
                if (direction === 'left') {
                    index -= flyLength;
                    if (initialField[index] === 0) {
                        initialField[index] = 1;
                        break;
                    }
                } else {
                    index += flyLength;
                    if (initialField[index] === 0) {
                        initialField[index] = 1;
                        break;
                    }
                }
            }
        }
    }


    return initialField.join(' ');

    function createArr(size, ladybugsIndexes) {
        let array = [];
        for (let i = 0; i < size; i++) {
            array[i] = 0;
        }
        array = fillFieldWithLadybugs(array, ladybugsIndexes);
        return array;
    }

    function fillFieldWithLadybugs(arr, indexes) {
        for (let i = 0; i < indexes.length; i++) {
            const index = +indexes[i];
            if (index < arr.length) {
                arr[index] = 1;
            }
        }
        return arr;
    }
}
console.log(ladybugs([3, '0 1', '0 right 1', '2 right 1']));
console.log(ladybugs([3, '0 1 2', '0 right 1', '1 right 1', '2 right 1']));
console.log(ladybugs([5, '3', '3 left 2', '1 left -2']));