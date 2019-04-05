function buyBTC(input) {
     
    const priceOfBitcoin = 11949.16;
    const pricePerGramGold = 67.51;
    let dayOfTheFirstPurchasedBitcoin = 0;
    let wallet = 0;
    let totalAmountBitcoins = 0;
    
    for (let i = 1; i <= input.length; i++) {
        let gold = +input[i - 1];
        const countOfDays = i;
        if (countOfDays % 3 === 0) {
            let stolenGold = gold / 100 * 30;
            gold -= stolenGold;
        }
        wallet += (gold * pricePerGramGold); 
        while (wallet >= priceOfBitcoin) {
            if (dayOfTheFirstPurchasedBitcoin === 0) {
                dayOfTheFirstPurchasedBitcoin = i;
            }
            
            totalAmountBitcoins += 1;
            wallet -= priceOfBitcoin;
        }
    }

    console.log(`Bought bitcoins: ${totalAmountBitcoins}`);
    if (totalAmountBitcoins > 0) {
        console.log(`Day of the first purchased bitcoin: ${dayOfTheFirstPurchasedBitcoin}`);
    }
    console.log(`Left money: ${wallet.toFixed(2)} lv.`);
}

byBTC([3124.15, 504.212, 2511.124]);
