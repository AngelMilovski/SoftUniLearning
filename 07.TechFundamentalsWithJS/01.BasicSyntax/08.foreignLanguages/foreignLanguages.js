function foreignLanguages(country) {
    if (country === 'England' || country === 'USA') {
        return 'English';
    } else if (country === 'Spain' || country === 'Argentina' || country === 'Mexico') {
        return 'Spanish';
    } else {
        return 'unknown';
    }
} 

const result = foreignLanguages('Germany');
console.log(result);