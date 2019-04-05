function phoneBook(input) {
    let arr = input;
    let phones = [];
    for (let item of arr) {
        const parts = item.split(' ');
        const name = parts[0];
        const number = parts[1];
        phones[name] = number;
    }
        
    for (const name in phones) {
        if (phones.hasOwnProperty(name)) {
           console.log(`${name} -> ${phones[name]}`);
        }
    }
}

phoneBook([
    'Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344'
]);