function calculateCarTax(type, kw, age) {
    kw = +kw;
    age = +age;
    let result = 0.0;

    switch (type) {
        case 'car':
        result = getTotalCarTax(kw, age);
            break;

        case 'motorcycle':
            result = getTotalCycleTax(kw);
            break;
    }

    return result.toFixed(2) + ' lv.';

    function getTotalCarTax(carPower, carAge) {
        return getTaxCoefficientFromPower(carPower) * getTaxCoefficientFromAge(carAge);
    }

    function getTotalCycleTax(volume) {
        if (volume > 750) {
            return 125;
        } else if (volume > 490) {
            return 94;
        } else if (volume > 350) {
            return 63;
        } else if (volume > 250) {
            return 44;
        } else if (volume > 125) {
            return 31;
        } else {
            return 15;
        }
    }

    function getTaxCoefficientFromPower(carPower) {
        if (carPower < 37) {
            return carPower * 0.43;
        } else if (carPower > 37 && carPower <= 55) {
            return carPower * 0.50;
        } else if (carPower > 55 && carPower <= 74) {
            return carPower * 0.68;
        } else if (carPower > 74 && carPower <= 110) {
            return carPower * 1.38;
        } else {
            return carPower * 1.54;
        }
    }

    function getTaxCoefficientFromAge(carAge) {
        if (carAge < 5) {
            return 2.80;
        } else if (carAge > 5 && carAge <= 14) {
            return 1.50;
        } else {
            return 1;
        }
    }
}

console.log(calculateCarTax('car', 90, 7));