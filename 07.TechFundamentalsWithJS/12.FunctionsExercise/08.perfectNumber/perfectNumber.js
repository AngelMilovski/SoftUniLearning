function perfectNumber(number) {
    number = +number;
    let getPositiveDivisors = function (num) {
        let numFactors = [];
        for (let i = 1; i <= num; i++) {
            if (num % i === 0 && !numFactors.includes(i)) {
                let diff = num / i;
                numFactors.push(i);

                if (diff != i) {
                    numFactors.push(diff);
                }
            }
        }

        return numFactors;
    };

    let sumOfPositiveDivisors = getPositiveDivisors(number)
    .filter(n => n != number)
    .reduce((acc, curr) => {
        acc += curr;
        return acc;
    }, 0);

    if (sumOfPositiveDivisors != number) {
        return 'It’s not so perfect.';
    } else {
        return 'We have a perfect number!';
    }
}

const output = perfectNumber(6);
console.log(output);