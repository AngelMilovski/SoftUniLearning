function spiceMustFlow(input) {
    let yieldDrops = +input;
    let days = 0;
    let extract = 0;
    while (yieldDrops >= 100) {
        days += 1;
        extract += yieldDrops - 26;
        yieldDrops -= 10;
    }
    if (extract >= 26) {
        extract -= 26;
    }
    console.log(days);
    console.log(extract);
}

spiceMustFlow(200);