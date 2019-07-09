// function solution() {
//     const receipts = {
//         apple: {
//             carbohydrate: 1,
//             flavour: 2
//         },
//         lemonade: {
//             carbohydrate: 10,
//             flavour: 20
//         },
//         burger: {
//             carbohydrate: 5,
//             fat: 7,
//             flavour: 3
//         },
//         eggs: {
//             protein: 5,
//             fat: 1,
//             flavour: 1
//         },
//         turkey: {
//             protein: 10,
//             carbohydrate: 10,
//             fat: 10,
//             flavour: 10
//         }
//     };

//     let ingredients = {
//         protein: 0,
//         carbohydrate: 0,
//         fat: 0,
//         flavour: 0
//     };

//     const restock = function (ingredient, quantity) {
//         if (ingredients.hasOwnProperty(ingredient)) {
//             ingredients[ingredient] += (+quantity);
//             return 'Success';
//         }
//     };

//     const prepare = function (recipe, countOfProduct) {
//         recipe = recipe.toLowerCase();
//         countOfProduct = +countOfProduct;
//         const notEnoughAvailableIngredient = Object
//             .entries(receipts[recipe])
//             .find((microelements) => {
//                 return ingredients[microelements[0]] - (microelements[1] * countOfProduct) < 0;
//             });

//         if (notEnoughAvailableIngredient) {
//             return `Error: not enough ${notEnoughAvailableIngredient[0]} in stock`;
//         } else {
//             Object
//                 .entries(receipts[recipe])
//                 .forEach((microelements) => {
//                     ingredients[microelements[0]] -= (microelements[1] * countOfProduct);
//                 });

//             return 'Success';
//         }
//     };

//     let report = function () {
//         let result = '';
//         Object
//             .entries(ingredients)
//             .forEach(ing => result += `${ing[0]}=${ing[1]} `);

//         return result.trim();
//     };

//     return function (str) {
//         let [command, type, quantity] = str.split(' ');
//         switch (command) {
//             case 'restock': return restock(type, quantity);
//             case 'prepare': return prepare(type, quantity);
//             case 'report': return report();
//         }
//     };
// }

const breakfastRobot = (function breakfastRobot() {
 
    let ingredients = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    };
 
    const recipes = {
        apple: { carbohydrate: 1, flavour: 2 },
        lemonade: { carbohydrate: 10, flavour: 20 },
        burger: { carbohydrate: 5, fat: 7, flavour: 3 },
        eggs: { protein: 5, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }
    };
 
    function restock(type, quantity) {
        ingredients[type] += quantity;
        return 'Success';
    }

    function prepare(type, quantity) {
        let areEnoughIngedients = false,
            neededIngredients = recipes[type];

        for (const key in neededIngredients) {
            let needed = neededIngredients[key] * quantity;
           
            let stored = ingredients[key];

            if (needed > stored) {
                areEnoughIngedients = false;
                return `Error: not enough ${key} in stock`;
            }
            else {
                areEnoughIngedients = true;
            }
        }

        if (areEnoughIngedients) {
            for (var key in neededIngredients) {
                let takenIngredients = neededIngredients[key] * quantity;
                ingredients[key] -= takenIngredients;
            }
            return 'Success';
        }
        console.log(neededIngredients);
    }


    function report(ingredients) {
        return `protein=${ingredients.protein} carbohydrate=${ingredients.carbohydrate}' +
        ' fat=${ingredients.fat} flavour=${ingredients.flavour}`;
    }
 
    return (params) => {
        let [command, type, quantity] = params.split(' ');
 
        if (command === 'restock') {
            return restock(type, Number(quantity));
        }
        else if (command === 'prepare') {
            return prepare(type, Number(quantity));
        }
        else if (command === 'report') {
            return report(ingredients);
        }
    };
})();

const arr = [
    'restock protein 100',
    'restock carbohydrate 100',
    'restock fat 100',
    'restock flavour 100',
    'report',
    'prepare eggs 2',
    'report',
    'prepare eggs 1',
    'report'
];

const result = breakfastRobot();
arr.forEach(line => console.log(result(line)));
