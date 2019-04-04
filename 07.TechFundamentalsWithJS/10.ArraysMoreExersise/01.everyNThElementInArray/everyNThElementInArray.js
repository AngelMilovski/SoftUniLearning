function solve(args) {
    let array = args.slice();
    const steps = +array.pop();
    let newArr = [];
    for (let i = 0; i < array.length; i += steps) {
        const element = array[i];
        newArr.push(element);
    }
    return newArr.join(' ');
}

const result = solve(['5', '20', '31', '4', '20', '2']);
console.log(result);