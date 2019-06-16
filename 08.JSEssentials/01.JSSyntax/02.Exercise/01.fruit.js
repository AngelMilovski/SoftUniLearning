function fruit(fruitType, fruitWeight, fruitPrice) {
    let weight = fruitWeight / 1000;
    let price = weight * fruitPrice;
    return `I need $${price.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${fruitType}.`;
}

console.log(fruit('apple', 1563, 2.35));

