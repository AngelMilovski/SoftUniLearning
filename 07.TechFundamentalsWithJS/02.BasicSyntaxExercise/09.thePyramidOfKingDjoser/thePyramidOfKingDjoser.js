function calculateResources(firstItem, secondItem) {
    let base = +firstItem;
    let increment = +secondItem;
    let materials = {
        requiredStones: 0,
        requiredMarble: 0,
        requiredLapisLazuli: 0,
        requiredGold: 0
    };
    let steps = 0;
    for (let i = base; i >= 1; i -= 2) {
        let currentStep = i * i;
        steps += 1;
        if (currentStep === 1 || currentStep === 4) {

            materials.requiredGold = currentStep * increment;

        } else {

            calculateMaterialsWithoutGold(increment, materials, i, steps);

        }
    }

    function calculateMaterialsWithoutGold(increment, materials, i, steps) {
        let stepPerimeter = i * i;
        let stonesPerimeter = ((i - 2 >= 0) ? ((i - 2) * (i - 2)) : 0);
        let marblePerimeter = (stepPerimeter - stonesPerimeter >= 0) ? (stepPerimeter - stonesPerimeter) : 0;
        if (steps % 5 === 0) {
            let lapisLazuliPerimeter = (i * i) - stonesPerimeter;
            materials.requiredLapisLazuli += lapisLazuliPerimeter * increment;
        } else {
            materials.requiredMarble += marblePerimeter * increment;
        }
        materials.requiredStones += stonesPerimeter * increment;
    }

    console.log(`Stone required: ${Math.ceil(materials.requiredStones)}`);
    console.log(`Marble required: ${Math.ceil(materials.requiredMarble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(materials.requiredLapisLazuli)}`);
    console.log(`Gold required: ${Math.ceil(materials.requiredGold)}`);
    console.log(`Final pyramid height: ${Math.floor(steps * increment)}`);
}

calculateResources(23, 0.5);