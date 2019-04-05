function dateFinder(params) {
    let regex = /\b(\d{1,2})(-)(?<month>Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\2(?<year>[1-9]\d{3})\b/g;
    
    let arrayOfDates = [];
    for (const line of params) {
        let match;
        while ((match = regex.exec(line)) !== null) {
            let year = +match.groups.year;
            let month = match.groups.month;
            if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
                if (month === 'Feb' && match[1] > 29) {
                    continue;
                }
            } else {
                if (month === 'Feb' && match[1] > 28) {
                    continue;
                }
            }

            if (month === 'Jan' && match[1] > 31) {
                continue;
            } else if (month === 'Mar' && match[1] > 31) {
                continue;
            } else if (month === 'Apr' && match[1] > 30) {
                continue;
            } else if (month === 'May' && match[1] > 31) {
                continue;
            } else if (month === 'Jun' && match[1] > 30) {
                continue;
            } else if (month === 'Jul' && match[1] > 31) {
                continue;
            } else if (month === 'Aug' && match[1] > 31) {
                continue;
            } else if (month === 'Sep' && match[1] > 30) {
                continue;
            } else if (month === 'Oct' && match[1] > 31) {
                continue;
            } else if (month === 'Nov' && match[1] > 30) {
                continue;
            } else if (month === 'Dec' && match[1] > 31) {
                continue;
            }

            arrayOfDates.push(match[0].replace(/-/g, ' '));
        }
    }

    arrayOfDates.forEach(date => console.log(date));
}

dateFinder([
    'I am born on 30-Feb-2000.',
    'This is not date: 512-Jan-1996.',
    'My father is born on the 29-Jul-1955.'
]);