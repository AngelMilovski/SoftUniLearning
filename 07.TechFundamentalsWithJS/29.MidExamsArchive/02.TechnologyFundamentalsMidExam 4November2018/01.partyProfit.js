function partyProfit(params) {
    companions = +params[0];
    days = +params[1];

    const earningCoinsPerDay = 50;
    const spendCoinsForFoodPerCompanion = 2;
    const spendCoinsForDrinkPerCompanion = 3;
    const gainCoinsPerCompanion = 20;
    let earnedCoins = 0;

    for (let i = 1; i <= days; i++) {
        let isThirdDay = i % 3 === 0;
        let isFifthDay = i % 5 === 0;
        let isTenthsDay = i % 10 === 0;
        let isFifteenthDay = i % 15 === 0;
        earnedCoins += earningCoinsPerDay;

        if (isTenthsDay) {
            companions -= 2;
        }

        if (isFifteenthDay) {
            companions += 5;
        }

        if (isThirdDay) {
            earnedCoins -= spendCoinsForDrinkPerCompanion * companions;
        }
        if (isFifthDay) {
            earnedCoins += gainCoinsPerCompanion * companions;
        }

        if (isThirdDay && isFifthDay) {
            earnedCoins -= spendCoinsForFoodPerCompanion * companions;
        }

        earnedCoins -= spendCoinsForFoodPerCompanion * companions;
    }

    const receivedCoins = Math.floor(earnedCoins / companions);
    console.log(`${companions} companions received ${receivedCoins} coins each.`);
}

partyProfit([15, 30]);