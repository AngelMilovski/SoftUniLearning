Number.result = (function () {
    let sum = 0;
    
    const add = function (n) {
        sum += n;
        return add;
    };
    
    add.toString = function () {
        return sum;
    };

    return add;
}());

console.log(Number.result(1)(6)(-3));