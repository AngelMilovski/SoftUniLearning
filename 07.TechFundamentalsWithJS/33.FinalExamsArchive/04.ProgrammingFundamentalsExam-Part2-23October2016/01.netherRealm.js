function netherRealm(params) {
    let demons = {};
    let array = params[0].split(new RegExp(',[ ]*', 'g')).map(e => e.trim());
    let patternForSymbols = /[^\d+\-*/.]/g;
    let patternForDigit = /[+-]?\d+(\.\d+)*/g;
    let patternForOperators = /[*/]/g;
 
    for (let name of array) {
        let symbols = name.match(patternForSymbols);
        let digits = name.match(patternForDigit);
        let operators = name.match(patternForOperators);
        let health = 0;
        let damage = 0;
        if (symbols) {
            health = symbols.reduce((acc, cur) => acc += cur.charCodeAt(0), 0);
        }

        if (digits) {
            damage = digits.map(n => +n).reduce((acc, cur) => acc += cur, 0);
        }

        if (operators) {
            for (let operator of operators) {
                switch (operator) {
                    case '*':
                        damage *= 2;
                        break;

                    case '/':
                        damage /= 2;
                        break;
                }
            }
        }

        demons[name] = {
            health,
            damage
        };
    }

    Object
        .keys(demons)
        .sort((a, b) => a.localeCompare(b))
        .forEach(name => console.log(`${name} - ${demons[name].health} health, ${(demons[name].damage).toFixed(2)} damage`));
}

// netherRealm(['M03ph-0.5s-0.5t0.0**']);
netherRealm(['M3ph1st0**,Azazel']);