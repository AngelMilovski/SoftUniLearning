const { expect } = require('chai');

function isSymmetric(arr) {
    if (!Array.isArray(arr))
        return false; // Non-arrays are non-symmetric
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}

console.log(isSymmetric([]));

describe('isSymmetric', () => {
  
    it('Return false when argument is not array', () => {
        const result = isSymmetric('a');
        expect(result).to.be.equal(false);
    });

    it('Shoult return true then array is symmetric', () => {
        const result = isSymmetric([1, 2, 1]);
        expect(result).to.be.equal(true);
    });

    it('Shoult return false when array is not symmetric', () => {
        const result = isSymmetric([1, 2, 4, 1, 2, 4]);
        expect(result).to.be.equal(false);
    });

    it('Shoult return true when array have only one element', () => {
        const result = isSymmetric([1]);
        expect(result).to.be.equal(true);
    });

    it('Shoult return false when array is empty', () => {
        const result = isSymmetric([]);
        expect(result).to.be.equal(true);
    });

    it('Shoult be false for array of different data types these are symmetric', () => {
        const result = isSymmetric([{}, undefined, [], 5, 'string', {}, 5, undefined, []]);
        expect(result).to.be.equal(false);
    });

    it('Shoult return true for array of same data types these are symmetric', () => {
        const result = isSymmetric([null, 5, {}, [], 'string', [], {}, 5, null]);
        expect(result).to.be.equal(true);
    });
});