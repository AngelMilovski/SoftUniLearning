function cookingByNumbers(params) {
    let number = +params.shift();

    let chop = function (number) {
        return number / 2;
    };

    let dice = function (number) {
        return Math.sqrt(number);
    };

    let spice = function (number) {
        return number + 1;
    };

    let bake = function (number) {
        return number * 3;
    };

    let fillet = function (number) {
        return number - (number / 100 * 20);
    };

    for (const el of params) {
        switch (el) {
            case 'chop':
                number = chop(number);
                break;

            case 'dice':
                number = dice(number);
                break;

            case 'spice':
                number = spice(number);
                break;

            case 'bake':
                number = bake(number);
                break;

            case 'fillet':
                number = fillet(number);
                break;
        }
        console.log(number);
    }
}

cookingByNumbers(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);