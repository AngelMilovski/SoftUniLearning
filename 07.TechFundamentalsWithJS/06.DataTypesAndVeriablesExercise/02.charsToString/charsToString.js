function charsToString(firstItem, secondItem, thirdItem) {
    const [firstChar, secondChar, thirdChar] = [firstItem, secondItem, thirdItem];
    return firstChar + secondChar + thirdChar;
}

const result = charsToString('a', 'b', 'c');
console.log(result);