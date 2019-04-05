function buildAWall(params) {
    let sections = params.slice().map(Number);
    const completedSectionHeight = 30;
    const usingCubicYardsOfConcrete = 195;
    const cubicYardOfConcretePesos = 1900;
    let amountOfConcreteUsedEachDay = [];
    let totalCostOfTheWall = 0;


    while (sections.length > 0) {
        let addedFoot = addFootOfHeightPerDay(sections);

        if (sections.includes(completedSectionHeight)) {
            sections = sections.filter(e => e != completedSectionHeight);
        }

        let totalCubicYards = addedFoot * usingCubicYardsOfConcrete;
        amountOfConcreteUsedEachDay.push(totalCubicYards);
        totalCostOfTheWall += totalCubicYards * cubicYardOfConcretePesos;
    }

    console.log(amountOfConcreteUsedEachDay.join(', '));
    console.log(totalCostOfTheWall + ' pesos');

    function addFootOfHeightPerDay(sections) {
        let addedFood = 0;
        for (let i = 0; i < sections.length; i++) {
            if (sections[i] + 1 <= completedSectionHeight) {
                sections[i] += 1;
                addedFood += 1;
            }
        }

        return addedFood;
    }
}

let testArray = [];
for (let i = 0; i < 200; i++) {
    testArray.push(29);
}
buildAWall(testArray);
