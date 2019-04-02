function solve(params) {
    let amountOfBatch = +params.shift();
    const cookiesInBox = 5;
    const singleCookieGram = 25;
    const cup = 140;
    const smallSpoon = 10;
    const bigSpoon = 20;
    let totalBoxes = 0;

    for (let i = 0; i < amountOfBatch; i++) {
        let amountOfFlourInGrams = +params.shift();
        let amountOfSugarInGrams = +params.shift();
        let amountOfCocoaInGrams = +params.shift();
        let flourCups = parseInt(amountOfFlourInGrams / cup);
        let sugarSpoon = parseInt(amountOfSugarInGrams / bigSpoon);
        let cocoaSpoon = parseInt(amountOfCocoaInGrams / smallSpoon);
        if (flourCups < 1 || sugarSpoon < 1 || cocoaSpoon < 1) {
            console.log('Ingredients are not enough for a box of cookies.');
        } else {
            let totalCookiePerBake = (cup + bigSpoon + smallSpoon) * Math.min(flourCups, sugarSpoon, cocoaSpoon) / singleCookieGram;
            let boxesOfCookies = Math.floor(totalCookiePerBake / cookiesInBox);
            console.log('Boxes of cookies: ' + boxesOfCookies);
            totalBoxes += boxesOfCookies;
        }
    }

    console.log('Total boxes: ' + totalBoxes);
}

solve([2, 200, 300, 500, 100, 200, 50]);
solve([1, 1400, 200, 100]);