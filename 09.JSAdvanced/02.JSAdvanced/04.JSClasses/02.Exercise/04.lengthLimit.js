class Stringer {
    constructor(string, length) {
        this.innerString = '' + string;
        this.innerLength = Math.max(0, length);
    }

    increase(increaseNumber) {
        this.innerLength += increaseNumber;
    }

    decrease(decreaseNumber) {
        this.innerLength = Math.max(0, this.innerLength - decreaseNumber);
    }

    toString() {
        let result = '';

        if (this.innerString.innerLength === 0) {
            result = '...';
        } else if (this.innerString.length <= this.innerLength) {
            result = this.innerString(0);
        } else {
            result = this.innerString.slice(0, this.innerLength);
            result += '...';
        }

        return result;
    }
}

const test = new Stringer('test', 3);
console.log(test.toString());