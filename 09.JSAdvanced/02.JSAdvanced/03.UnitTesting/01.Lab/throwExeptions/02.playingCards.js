function makeCard(face, suit) {
    const validFace = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    const validSuit = ['S', 'H', 'D', 'C'];

    function Card(face, suit) {
        const inputFace = face.toUpperCase();
        const inputSuit = suit.toUpperCase();

        if (!validFace.includes(inputFace)) {
            throw new Error('Invalit card face ' + face);
        }

        if (!validSuit.includes(inputSuit)) {
            throw new Error('Invalid card suit ' + suit);
        }

        this._face = face;
        this._suit = suit;
        this.toString = () => {

            const suitToChar = {
                S: '\u2660',
                H: '\u2665',
                D: '\u2666',
                C: '\u2663'
            };

            return this._face + suitToChar[this._suit];
        };
    }

    return new Card(face, suit);
}

console.log('' + makeCard('2', 'S'));
console.log('' + makeCard('10', 'H'));
console.log('' + makeCard('1', 'C'));
