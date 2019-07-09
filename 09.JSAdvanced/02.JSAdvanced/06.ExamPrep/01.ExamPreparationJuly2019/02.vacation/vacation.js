class Vacation {
    constructor(organizer, destination, budget) {
        this.organizer = organizer;
        this.destination = destination;
        this.budget = budget;
        this.kids = {};
    }

    registerChild(name, grade, budget) {
        if (budget < this.budget) {
            return `${name}'s money is not enough to go on vacation to ${this.destination}.`;
        }

        if (!this.kids[grade]) {
            this.kids[grade] = [];
        } else {
            const allKids = this.kids[grade].map(kid => kid.slice(0, kid.indexOf('-')));

            if (allKids.includes(name)) {
                return `${name} is already in the list for this ${this.destination} vacation.`;
            }
        }

        this.kids[grade].push(`${name}-${budget}`);
        return this.kids[grade];
    }

    removeChild(name, grade) {
        if (this.kids[grade].find(kid => kid.split('-')[0] === name)) {
            this.kids[grade] = this.kids[grade]
                .filter(kid => kid.slice(0, kid.indexOf('-')) !== name);
            return grade;
        } else {
            return `We couldn't find ${name} in ${grade} grade.`;
        }
    }

    toString() {
        const countOfChildren = this.numberOfChildren;
        if (countOfChildren === 0) {
            return `No children are enrolled for the trip and the organization of ${this.organizer} falls out...`;
        }

        let result = `${this.organizer} will take ${countOfChildren} children on trip to ${this.destination}\n`;
        Object
            .keys(this.kids)
            .sort((a, b) => {
                a = +a;
                b = +b;
                return a - b;
            })
            .forEach((grade) => {
                result += `Grade: ${grade}\n`;
                this.kids[grade].forEach((kid, i) => {
                    result += `${i + 1}. ${kid}\n`;
                });
                result += '\n';
            });

        return result.trim();
    }

    get numberOfChildren() {
        return Object
            .values(this.kids)
            .reduce((acc, cur) => {
                acc += cur.length;
                return acc;
            }, 0);
    }
}

let vacation = new Vacation('Miss Elizabeth', 'Dubai', 2000);
vacation.registerChild('Gosho', 5, 3000);
vacation.registerChild('Lilly', 6, 1500);
vacation.registerChild('Pesho', 7, 4000);
vacation.registerChild('Tanya', 5, 5000);
vacation.registerChild('Mitko', 10, 5500);
console.log(vacation.toString());