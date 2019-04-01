function airPollution(matrix, array) {
    let mapOfSofia = matrix.map((r) => r.split(' ').map(Number));
    let affectingInTheAir = array.slice();
    const thresholdOfContamination = 50;

    for (let item of affectingInTheAir) {
        let influence = item.split(' ');
        let forceAffected = influence[0];
        let number = +influence[1];

        switch (forceAffected) {
            case 'breeze':
                mapOfSofia[number] = mapOfSofia[number].map((a) => {
                    a -= 15;
                    return Math.max(0, a);
                });

                break;

            case 'gale':
                for (let i = 0; i < mapOfSofia.length; i++) {
                    let airPolluted = mapOfSofia[i][number] - 20;
                    mapOfSofia[i][number] = Math.max(0, airPolluted);
                }

                break;

            case 'smog':
                mapOfSofia = increaseAllCellsInMatrix(mapOfSofia, number);
                break;
        }
    }

    let pollutedAreas = [];
    for (let i = 0; i < mapOfSofia.length; i++) {
        for (let j = 0; j < mapOfSofia.length; j++) {
            let element = mapOfSofia[i][j];
            if (element >= thresholdOfContamination) {
                pollutedAreas.push(`[${i}-${j}]`);
            }
        }
    }

    if (pollutedAreas.length > 0) {
        console.log('Polluted areas: ' + pollutedAreas.join(', '));
    } else {
        console.log('No polluted areas');
    }

    function increaseAllCellsInMatrix(matrix, value) {
        return matrix.map(r => r.map(c => c += value));
        
    }
}

airPollution(["5 7 72 14 4",
"41 35 37 27 33",
"23 16 27 42 12",
"2 20 28 39 14",
"16 34 31 10 24"],
["breeze 1", "gale 2", "smog 25"]);