function solve(firstItem, secondItem, thirdItem) {
    const [firstName, secondName, delimiter] = [firstItem, secondItem, thirdItem];
    return `${firstName}${delimiter}${secondName}`;
}

console.log(solve('John', 'Smith','->'));
console.log(solve('Jan', 'White', '<->'));
console.log(solve('Linda', 'Terry', '=>'));