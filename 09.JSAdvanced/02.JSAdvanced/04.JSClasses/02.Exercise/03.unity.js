// const Rat = function Rat(name) {
//     this.name = name;
//     this.unitedRats = [];
// };

// Rat.prototype.unite = function unite(otherRat) {
//     if (otherRat instanceof Rat) {
//         this.unitedRats.push(otherRat);
//     }
// };

// Rat.prototype.getRats = function getRats() {
//     return this.unitedRats;
// };

// Rat.prototype.toString = function toString() {
//     let result = this.name;
//     this.unitedRats.forEach(rat => result += `\n##${rat}`);
//     return result;
// };

class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats = [];
    }

    getRats() {
        return this.unitedRats;
    }

    unite(otherRat) {
        if (otherRat instanceof Rat) {
            this.unitedRats.push(otherRat);
        }
    }

    toString() {
        let result = this.name;
        this.unitedRats.forEach(rat => result += `\n##${rat}`);
        return result;
    }
}

const firstRat = new Rat('Pesho');
console.log(firstRat.toString());
console.log(firstRat.getRats());
firstRat.unite(new Rat('Gosho'));
firstRat.unite(new Rat('Alex'));
console.log(firstRat.getRats());
console.log(firstRat.toString());
