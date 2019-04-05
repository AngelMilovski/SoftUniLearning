function arrayManipulator(params, args) {
    let array = params.slice();
    for (const line of args) {
        let parts = line.split(/\s+/);
        let command = parts.shift();
        let index;

        switch (command) {
            case 'add':
                index = +parts.shift();
                let element = +parts.shift();
                array.splice(index, 0, element);
                break;

            case 'addMany':
                index = +parts.shift();
                let elements = parts.map(Number).slice();
                array.splice(index, 0, ...elements);
                break;
            case 'contains':
                let searchElement = +parts;
                console.log(array.indexOf(searchElement));
                break;

            case 'remove':
                array.splice(+parts, 1);
                break;

            case 'shift':
                let position = +parts % array.length;
                for (let i = 0; i < position; i++) {
                    let number = array.shift();
                    array.push(number);
                }
                break;

            case 'sumPairs':
                let newArr = [];
                for (let i = 0; i < array.length - 1; i += 2) {
                    let curr = array[i];
                    let next = array[1 + i];
                    newArr.push(curr + next);
                }

                if (array.length % 2 != 0) {
                    newArr.push(array.pop());
                }
                array = newArr.slice();
                break;

            case 'print':
                return (`[ ${array.join(', ')} ]`);
        }
    }
}

const output = arrayManipulator(
    [1, 2, 3, 4, 5],
    ['addMany 5 9 8 7 6 5', 'contains 15', 'remove 3', 'shift 1', 'print']
);

console.log(output);
// [ 2, 3, 5, 9, 8, 7, 6, 5, 1 ]