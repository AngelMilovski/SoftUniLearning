function rightPlace(firstItem, secondItem, thirdItem) {
    let [str, char, result] = [firstItem, secondItem, thirdItem];
    let res = str.replace('_', char);
    return (res === result) ? 'Matched' : 'Not Matched';
}

console.log(rightPlace('Str_ng', 'I', 'Strong'));
console.log(rightPlace('Str_ng', 'i', 'String'));