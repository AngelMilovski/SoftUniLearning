(function solve() {

    Array.prototype.addAll = function (arr) {
        arr.forEach(e => this.push(e));
    };

    Array.prototype.last = function () {
        return this[this.length - 1];
    };

    Array.prototype.skip = function (n) {
        if (n > 0 && n < this.length) {
            return this.filter((v, i) => {
                return i >= n;
            });
        } 
    };

    Array.prototype.take = function (n) {
        if (n > 0 && n <= this.length) {
            return this.filter((v, i) => {
                return i < n;
            });
        } 
    };

    Array.prototype.sum = function () {
        let result = 0;
        this.forEach(v => result += v);
        return result;
    };

    Array.prototype.average = function () {
        let result = 0;
        this.forEach(v => result += v);
        return result / this.length;
    };
})();

let arr = [1, 2, 3];
arr = arr.average();
console.log(arr);

const isRight = Array.prototype.hasOwnProperty('last');
console.log(isRight); 