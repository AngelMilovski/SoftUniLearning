function printDeckOfCards(cards) {
    const makeCard = function(face, suit) {
        const validFace = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        const validSuit = ['S', 'H', 'D', 'C'];
    
        function Card(face, suit) {
            const inputFace = face.toUpperCase();
            const inputSuit = suit.toUpperCase();
    
            if (!validFace.includes(inputFace)) {
                throw new Error();
            }
    
            if (!validSuit.includes(inputSuit)) {
                throw new Error();
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
    };

    let deck = [];
    for (const card of cards) {
        const cardFace = card.slice(0, card.length - 1);
        const cardSuit = card.slice(card.length - 1);
        
        try {
            deck.push(makeCard(cardFace, cardSuit));
        } catch (err) {
            console.log('Invalid card: ' + card);
            return;
        }
    }

    console.log(deck.join(' '));
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '1C', '3D', 'QD',]);