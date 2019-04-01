function gladiatorExpenses(firstItem, secondItem, thirdItem, fourthItem, fifthItem) {
    const lostGames = +firstItem,
        helmetPrice = +secondItem,
        swordPrice = +thirdItem,
        shieldPrice = +fourthItem,
        armorPrice = +fifthItem;

    let countOfTrashedHelmet = 0;
    let countOfTrashedSword = 0;
    let countOfTrashedShield = 0;
    let countOfTrashedArmor = 0;
    let currentCountOfTrashedShield = 0;

    for (let lostGame = 1; lostGame <= lostGames; lostGame++) {
        let isBrokenHelmet = false;
        let isBrokenSword = false;

        if (lostGame % 2 === 0) {
            isBrokenHelmet = true;
            countOfTrashedHelmet += 1;
        }
        if (lostGame % 3 === 0) {
            isBrokenSword = true;
            countOfTrashedSword += 1;
        }
        if (isBrokenHelmet && isBrokenSword) {
            currentCountOfTrashedShield += 1;
            countOfTrashedShield += 1;
        }
        if (currentCountOfTrashedShield === 2) {
            countOfTrashedArmor += 1;
            currentCountOfTrashedShield = 0;
        }
    }
    const neededMoneyForHelmetRepairs = countOfTrashedHelmet * helmetPrice;
    const neededMoneyForSwordRepairs = countOfTrashedSword * swordPrice;
    const neededMoneyForShieldRepairs = countOfTrashedShield * shieldPrice;
    const neededMoneyForArmorRepairs = countOfTrashedArmor * armorPrice;
    const aureus = neededMoneyForHelmetRepairs + neededMoneyForSwordRepairs +
        neededMoneyForShieldRepairs + neededMoneyForArmorRepairs;

    return `Gladiator expenses: ${aureus.toFixed(2)} aureus`;
}

const result = gladiatorExpenses(1000, 1000, 1000, 1000, 1000);
console.log(result);