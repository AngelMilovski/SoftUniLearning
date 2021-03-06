const result = (function () {
    const Suits = {
        CLUBS: '\u2663',
        DIAMONDS: '\u2666',
        HEARTS: '\u2665',
        SPADES: '\u2660'
      };
     
      const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

      class Card {
          constructor(face, suit) {
            this.face = face;
            this.suit = suit;
          }

          get face() {
              return this._face;
          }

          set face(face) {
              if (!faces.includes(face)) {
                  throw new Error('Invalid face!');
              }

              this._face = face;
          }

          get suit() {
              return this._suit;
          }

          set suit(suit) {
              if (!Object.values(Suits).includes(suit)) {
                  throw new Error('Invalid suit');
              }

              this._suit = suit;
          }
      }

    return {
        Suits,
        Card
    };
}());

const Card = result.Card;
const Suits = result.Suits;

const card = new Card('Q', Suits.CLUBS);
card.face = 'A';
card.suit = Suits.DIAMONDS;
const card2 = new Card('1', card.suit);