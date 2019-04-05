function christmasSpirit(params) {
    let quantity = +params[0];
    let finishDay = +params[1];

    const priceOrnamentPerPiece = 2;
    const priceTreeSkirtPiece = 5;
    const priceTreeGarland = 3;
    const priceTreeLights = 15;

    let spirit = 0;
    let totalCost = 0;

    for (let i = 2; i <= finishDay; i++) {
        let cost = 0; 
        let isSecondDay = i % 2 === 0;
        let isThirdDay = i % 3 === 0;
        let isFifthDay = i % 5 === 0;
        let isTenthDay = i % 10 === 0;
        let isEleventhDay = i % 11 === 0;
        
        if (isEleventhDay) {
            quantity += 2;
        }

        if (isSecondDay) {
            spirit += 5;
            cost += priceOrnamentPerPiece * quantity;
        }

        if (isThirdDay) {
            spirit += 13;
            cost += (priceTreeSkirtPiece * quantity) + (priceTreeGarland * quantity);
        }

        if (isFifthDay) {
            spirit += 17;
            cost += priceTreeLights * quantity;
            if (isThirdDay) {
                spirit += 30;
            }
        }

        if (isTenthDay) {
            cost += priceTreeSkirtPiece + priceTreeGarland + priceTreeLights;
            spirit -= 20;
            if (i === finishDay) {
                spirit -= 30;
            }
        }

        totalCost += cost;
    }

    console.log('Total cost: ' + totalCost);
    console.log('Total spirit: ' + spirit);
}

christmasSpirit([3, 20]);