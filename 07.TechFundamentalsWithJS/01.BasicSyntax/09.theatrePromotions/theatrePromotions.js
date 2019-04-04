function theatrePromotions(firstEl, secondEl) {
    const typeOfDay = firstEl;
    const age = +secondEl;

    switch (typeOfDay) {
        case 'Weekday':
            if (age >= 0 && age <= 18 || age > 64 && age <= 122) {
                return `${12}$`;
            } else if (age > 18 && age <= 64) {
                return `${18}$`;
            } else {
                return 'Error!';
            }

        case 'Weekend':

            if (age >= 0 && age <= 18 || age > 64 && age <= 122) {
                return `${15}$`;
            } else if (age > 18 && age <= 64) {
                return `${20}$`;
            } else {
                return 'Error!';
            }
            
        case 'Holiday':

            if (age >= 0 && age <= 18) {
                return `${5}$`;
            } else if (age > 18 && age <= 64) {
                return `${12}$`;
            } else if (age > 64 && age <= 122) {
                return `${10}$`;
            } else {
                return 'Error!';
            }
        default:
            return 'Error!';
    }
}

const result = theatrePromotions('Holiday', 15);
console.log(result);