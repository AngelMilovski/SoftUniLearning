function fuelMoney(firstItem, secondItem, thirdItem) {
    let [distance, passengers, pricePerLiterDiesel] = [+firstItem, +secondItem, +thirdItem];
    let neededFuel = (distance / 100) * 7;
    neededFuel += passengers * 0.100;
    let price = neededFuel * pricePerLiterDiesel;
    console.log(`Needed money for that trip is ${price}lv.`);
}

fuelMoney(260, 9, 2.49);