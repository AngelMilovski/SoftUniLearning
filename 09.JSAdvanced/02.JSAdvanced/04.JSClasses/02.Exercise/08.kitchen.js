class Kitchen {
    constructor(budget) {
        this.budget = budget;
        this.menu = {};
        this.productsInStock = {};
        this.actionsHistory = [];
        this.mealCount = 0;
    }

    loadProducts(arrayOFStrings) {
        this.actionsHistory = [];
        arrayOFStrings
            .forEach((line) => {
                let [productName, quantity, price] = line.split(' ');
                quantity = +quantity;
                price = +price;
                let historyMessage = '';
                if (price <= this.budget) {
                    this.budget -= price;
                    if (!this.productsInStock[productName]) {
                        this.productsInStock[productName] = quantity;
                    } else {
                        this.productsInStock[productName] += quantity;
                    }

                    historyMessage = `Successfully loaded ${quantity} ${productName}`;
                } else {
                    historyMessage = `There was not enough money to load ${quantity} ${productName}`;
                }

                this.actionsHistory.push(historyMessage);
            });

        return this.actionsHistory.join('\n');
    }

    addToMenu(meal, neededProducts, price) {
        let message = '';
        if (this.menu[meal]) {
            message = `The ${meal} is already in our menu, try something different.`;
        } else {
            this.mealCount += 1;
            message = `Great idea! Now with the ${meal} we have ${this.mealCount} meals in the menu, other ideas?`;
            this.menu[meal] = [];
            this.menu[meal].push(+price);
            this.menu[meal].push(neededProducts
                .reduce((acc, cur) => {
                    const [product, neededQuantity] = cur.split(' ');
                    acc[product] = +neededQuantity;
                    return acc;
                }, {}));
        }

        return message;
    }

    showTheMenu() {
        let message = '';
        const meals = Object.keys(this.menu);
        if (meals.length) {
            meals.forEach((meal) => {
                const mealPrice = this.menu[meal][0];
                message += `${meal} - $ ${mealPrice}\n`;
            });
        } else {
            message = 'Our menu is not ready yet, please come later...';
        }

        return message;
    }

    makeTheOrder(meal) {
        let message = '';
        if (!this.menu[meal]) {
            message = `There is not ${meal} yet in our menu, do you want to order something else?`;
        } else {
            const neededProducts = this.menu[meal][1];
            const haveAllNeededProducts = Object
                .keys(neededProducts)
                .some((productName) => {
                    return neededProducts[productName] <= this.productsInStock[productName];
                });

            if (haveAllNeededProducts) {
                Object
                    .keys(neededProducts)
                    .forEach((productName) => {
                        this.productsInStock[productName] -= neededProducts[productName];
                    });

                const price = this.menu[meal][0];
                this.budget += price;
                message = `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${price}.`;
            } else {
                message = `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
            }
        }

        return message;
    }
}

const kitchen = new Kitchen(1000);
console.log(kitchen.loadProducts(['Banana 10 5',
    'Banana 20 10',
    'Strawberries 50 30',
    'Yogurt 10 10',
    'Yogurt 500 1500',
    'Honey 5 50']));

console.log(kitchen.addToMenu('frozenYogurt', [
    'Yogurt 1',
    'Honey 1',
    'Banana 1',
    'Strawberries 10'
], 9.99));
console.log(kitchen.addToMenu('frozenYogurt', [
    'Flour 0.5',
    'Oil 0.2',
    'Yeast 0.5',
    'Salt 0.1',
    'Sugar 0.1',
    'Tomato sauce 0.5',
    'Pepperoni 1',
    'Cheese 1.5'
], 15.55));

console.log(kitchen.makeTheOrder('frozenYogurt'));
console.log(typeof kitchen.menu);
console.log(typeof kitchen.productsInStock);
console.log(typeof kitchen.actionsHistory);