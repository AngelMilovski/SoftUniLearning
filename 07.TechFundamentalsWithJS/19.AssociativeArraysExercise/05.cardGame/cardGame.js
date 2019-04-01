function cardGame(input) {
    let players = new Map();
   
    for (let line of input) {
        const currentHands = new Set();
        const parts = line.split(': ');
        const name = parts[0];
        const cards = parts[1].split(', ');
        if (!players.has(name)) {
            players.set(name, new Set());
        }
        fillCards(players, name, cards);
        
    }
    
    for (let [name, hands] of [...players.entries()]) {
        console.log(name + ': ' + getPower(hands));
    }


    function getPower(cards) {
        let sum = 0;
        for (let card of cards) {
            let power = card.substring(0, card.length - 1);
            let type = card.substring(card.length - 1);
            switch (type) {

                case 'S':
                    type = 4;
                    break;

                case 'H':
                    type = 3;
                    break;

                case 'D':
                    type = 2;
                    break;

                case 'C':
                    type = 1;
                    break;
            }
            if (power === 'J' || power === 'Q' || power === 'K' || power === 'A') {
                power = getTypePower(power);
            }
            sum = sum + (power * type);
        }
        return sum;
    }

    function getTypePower(power) {
        switch (power) {
            case 'J': return  11;
            case 'Q': return 12; 
            case 'K': return 13;
            case 'A': return 14;
        }
    }

    function fillCards(players, name, cards) {

        for (let card of cards) {
            players.get(name).add(card);
        }
    }
}

cardGame([
    'Pesho: 2C, 4H, 9H, AS, QS',
    'Slav: 3H, 10S, JC, KD, 5S, 10S',
    'Peshoslav: QH, QC, QS, QD',
    'Slav: 6H, 7S, KC, KD, 5S, 10C',
    'Peshoslav: QH, QC, JS, JD, JC',
    'Pesho: JD, JD, JD, JD, JD, JD'
]);
