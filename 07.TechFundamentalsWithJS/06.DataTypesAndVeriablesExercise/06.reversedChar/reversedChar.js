function reversedChar(firstItem, secondItem, thirdItem) {
    const [firstChar, secondChar, thirdChar] = [firstItem, secondItem, thirdItem];
    return `${thirdChar} ${secondChar} ${firstChar}`;
}

const result = reversedChar('A', 'B', 'C');
console.log(result);