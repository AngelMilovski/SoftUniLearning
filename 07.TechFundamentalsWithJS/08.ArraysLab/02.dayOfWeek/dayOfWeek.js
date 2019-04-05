function dayOfWeek(input) {
    const number = +input;
    const days = [
        'Invalid day!',
        'Monday', 'Tuesday',
        'Wednesday',
        'Thursday',
        'Friday',
        'Saturday',
        'Sunday'
    ];
    if (number < 0 || number > 7) {
        return 'Invalid day!';
    } else {
        return days[number];
    }
}

const result = dayOfWeek(0);
console.log(result);