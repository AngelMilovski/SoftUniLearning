function monthPrinter(number) {
    const month = [
        'Error!',
        'January', 
        'February', 
        'March', 
        'April', 
        'May', 'June', 
        'July', 'August', 
        'September', 
        'October', 
        'November', 
        'December'
    ];

    if (number < 0 || number > 12) {
        return 'Error!';
    }

    return month[number];
}

const result = monthPrinter(-1);
console.log(result);