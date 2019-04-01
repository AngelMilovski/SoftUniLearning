function ages(number) {
    const age = +number;
    if (age >= 0 && age <= 2) {
        return 'baby';
    } else if (age > 2 && age <= 13) {
        return 'child';
    } else if (age > 13 && age <= 19) {
        return 'teenager';
    } else if (age > 19 && age <= 65) {
        return 'adult';
    } else {
        return 'elder';
    }
}

console.log(ages(66));