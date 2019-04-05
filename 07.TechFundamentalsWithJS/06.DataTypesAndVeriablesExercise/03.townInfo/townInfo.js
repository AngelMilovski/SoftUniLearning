function townInfo(firstItem, secondItem, thirdItem) {
    const [townName, population, townArea] = [firstItem, +secondItem, +thirdItem];
    return `Town ${townName} has population of ${population} and area ${townArea} square km.`;
}

console.log(townInfo('Sofia', '1286383', '492'));