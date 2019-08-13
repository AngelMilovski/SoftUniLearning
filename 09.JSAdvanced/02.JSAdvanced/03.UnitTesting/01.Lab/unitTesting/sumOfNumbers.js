const { expect } = require('chai');

function sum(arr) {
    let sum = 0;
    for (num of arr)
        sum += Number(num);
    return sum;
}

describe('Sum', function () {
    it('Sum shoult to be function', (done) => {
        const result = sum;
        expect(result).to.be.a('function');
        done();
    });

    it('Shoult return 0 when it is called empty array', (done) => {
        const result = sum([]);
        const expected = 0;
        expect(result).to.be.equal(expected);
        done();
    });

    it('Shoult return NaN when any of the arguments is not number', (done) => {
        const result = sum([1, 'string']);
        expect(result).to.be.equal(NaN);
        done();
    });

    it('When is called with 1 argument then shoult return the result as same argument', () => {
        const result = sum([2]);
        expect(result).to.be.equal(2);
    });

    it('Shoult return a number when arguments are number as string', () => {
        const result = sum('2' + '3');
        expect(result).to.be.a('number');
    });
});