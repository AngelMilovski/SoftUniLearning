function solve(num) {
    for (let i = 0; i < num; i++) {
        for (let j = 0; j < num; j++) {
            for (let k = 0; k < num; k++) {
                let firstLetter = String.fromCharCode(97 + (i % 26));
                let secondLetter = String.fromCharCode(97 + (j % 26));
                let thirdLetter = String.fromCharCode(97 + (k % 26));
                console.log(firstLetter + secondLetter + thirdLetter);
            }  
        }
    }
}

solve(27);
