function solve(params) {
    let array = params.shift().split(' ').map(Number);
    params.pop();
    for (const line of params) {
        let tokens = line.split(' ');
        let command = tokens[0];
        let value = +tokens[1];
        let index = array.indexOf(value);
        switch (command) {

            case 'Add':
                array.push(value);
                break;

            case 'Remove':
                if (index < 0) {
                    if (value >= 0 && value < array.length) {
                        index = value;
                        array.splice(index, 1);
                    }
                } else {
                    array.splice(index, 1);
                }
                break;

            case 'Replace':
                if (index > -1) {
                    array.splice(index, 1, +tokens[2]);
                }
                break;

            case 'Increase':
                let increasingValue = getFirstBiggerNumber(array, value);
                if (increasingValue === 0) {
                    break;
                }
                if (!increasingValue) {
                    increasingValue = array[array.length - 1];
                }

                array = increaseAllElementsInArray(array, increasingValue);
                break;

            case 'Collapse':
                array = removeAllSmallerElements(array, value);
                break;
        }
    }

    console.log(array.join(' '));

    function getFirstBiggerNumber(array, value) {
        return array.find(v => v >= value);
    }

    function increaseAllElementsInArray(array, increasingValue) {
        return array.map(v => v += increasingValue);
    }

    function removeAllSmallerElements(array, value) {
        return array.filter(v => v >= value);
    }
}

solve([
    '1 4 5 19 13 42 69 24',
    'Add 1',
    'Remove 3',
    'Remove 4',
    'Remove 15',
    'Replace 0 26',
    'Replace 1 26',
    'Mort'
]);