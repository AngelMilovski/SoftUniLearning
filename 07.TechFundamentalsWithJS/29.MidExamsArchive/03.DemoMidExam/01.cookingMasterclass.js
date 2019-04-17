function cookingMasterclass(params) {
    // budget – floating-point number in range [0.00…1,000.00]
    // students – integer in range [0…100]
    // price of flour for a package – floating-point number in range [0.00…100.00]
    // price of egg for a single egg – floating-point number in range [0.00…100.00]
    // price of apron for a single apron – floating-point number in range [0.00…100.00]
    let budget = +params[0];
    let students = +params[1];
    const twentyPercentOFApron = students / 100 * 20;
    let priceOfFlours = (students - parseInt(students / 5)) * +params[2];
    let priceOfEggs = students * (+params[3] * 10);
    let priceOfAprons = Math.ceil(students + twentyPercentOFApron) * +params[4];

    let totalPrice = priceOfFlours + priceOfEggs + priceOfAprons;

    if (totalPrice > budget) {
        console.log(`${(totalPrice - budget).toFixed(2)}$ more needed.`);
    } else {
        console.log(`Items purchased for ${totalPrice.toFixed(2)}$.`);
    }
}

cookingMasterclass([
    50,
2,
1.0,
0.10,
10.0
]);