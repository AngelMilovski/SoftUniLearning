function bunnyKill(hangar) {
    let bombs = hangar.pop().split(' ').map(e => e.split(',').map(Number));
    hangar = hangar.map(e => e.split(' ').map(Number));
    let snowballDmg = 0;
    let killedBunnies = 0;

    for (let bomb of bombs) {
        let row = bomb[0];
        let col = bomb[1];

        let powerOfBomb = hangar[row][col];
        if (powerOfBomb > 0) {
            activateBomb(hangar, row, col, powerOfBomb);
            snowballDmg += powerOfBomb;
            killedBunnies += 1;
        }
    }

    let multidimensionalArray = hangar.reduce((acc, curr) => {
        curr = curr.filter(v => v > 0);
        if (curr.length > 0) {
            acc.push(curr);
        }
        return acc;
    }, []);

    snowballDmg += multidimensionalArray.reduce((acc, curr) => {
        acc += curr.reduce((acc, curr) => acc += curr, 0);
        return acc;
    }, 0);

    killedBunnies += multidimensionalArray.reduce((acc, curr) => acc += curr.length, 0);

    console.log(snowballDmg);
    console.log(killedBunnies);

    function activateBomb(hangar, row, col, power) {
        let startRow = Math.max(0, row - 1);
        let endRow = Math.min(row + 1, hangar.length - 1);
        let startCol = Math.max(0, col - 1);

        for (let i = startRow; i <= endRow; i++) {
            let endCol = Math.min(col + 1, hangar[i].length - 1);
            for (let j = startCol; j <= endCol; j++) {
                hangar[i][j] -= power;
            }
        }
    }
}


bunnyKill(['10 10 10',
'10 10 10', 
'10 10 10',
'0,0']);