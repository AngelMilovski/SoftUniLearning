function arrayRotation(args, number) {
    let array = args.slice();
    const rotationCount = +number % array.length;
    for (let i = 0; i < rotationCount; i++) {
        const element = array.shift();
        array.push(element);
    }
    return array.join(' ');
}

const result = arrayRotation(
    [2, 4, 15, 31], 5);
console.log(result);