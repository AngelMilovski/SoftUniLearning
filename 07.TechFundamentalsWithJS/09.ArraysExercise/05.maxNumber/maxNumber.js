function maxNumber(args) {
    const array = args.map(Number);
    return array
        .filter((value, index) => {
            let isBigger = true;
            const current = value;
            for (let i = index + 1; i < args.length; i++) {
                const next = args[i];
                if (current <= next) {
                    isBigger = false;
                    break;
                }
            }
            return isBigger;
        })
        .reduce((acc, curr) => {
            acc.push(curr);
            return acc;
        }, [])
        .join(' ');
}

const result = maxNumber([41, 41, 34, 20]);
console.log(result);