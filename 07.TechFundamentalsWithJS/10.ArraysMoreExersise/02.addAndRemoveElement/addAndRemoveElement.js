function addAndRemoveElement(args) {
    const array = args.slice();
    let newArr = [];

    for (let i = 0; i < array.length; i++) {
        let initialNumber = 1 + i;
        const command = array[i];
        switch (command) {
            case 'add':
                newArr.push(initialNumber);
                break;
        
            case 'remove':
            if (newArr.length > 0) {
                newArr.pop();
            }
                break;
        }
    }

    return (newArr.length > 0) ? newArr.join(' ') : 'Empty';
}

const result = addAndRemoveElement(['add', 'add', 'add', 'add']);
console.log(result);