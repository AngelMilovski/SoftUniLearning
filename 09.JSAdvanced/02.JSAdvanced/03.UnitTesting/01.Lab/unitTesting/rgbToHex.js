function rgbToHexColor(red, green, blue) {
    if (!Number.isInteger(red) || (red < 0) || (red > 255))
        return undefined; // Red value is invalid
    if (!Number.isInteger(green) || (green < 0) || (green > 255))
        return undefined; // Green value is invalid
    if (!Number.isInteger(blue) || (blue < 0) || (blue > 255))
        return undefined; // Blue value is invalid
    return "#" +
        ("0" + red.toString(16).toUpperCase()).slice(-2) +
        ("0" + green.toString(16).toUpperCase()).slice(-2) +
        ("0" + blue.toString(16).toUpperCase()).slice(-2);
}

console.log(rgbToHexColor([0, 0, 0], [255, 255, 255], [255, 158, 170]));

const { expect, assert } = require('chai');

describe('rgbToHexColor(red, green, blue) returns hexadecimal color based on 3 integers', () => {
    describe('Special cases (invalid input)', () => {
      it('should return undefined for invalid red values', () => {
        const [redArr, green, blue] = [[2.5, -1, 256], 100, 100];
        redArr.forEach(red => {
            expect(rgbToHexColor(red, green, blue)).to.be.equal(undefined);
        });
      });
  
      it('should return undefined for invalid green values', () => {
        const [red, greenArr, blue] = [100, [2.5, -1, 256], 100];
        greenArr.forEach(green => {
          expect(rgbToHexColor(red, green, blue)).to.be.equal(undefined);
        });
      });
  
      it('should return undefined for invalid blue values', () => {
        const [red, green, blueArr] = [100, 100, [2.5, -1, 256]];
        blueArr.forEach(blue =>
          assert.isUndefined(rgbToHexColor(red, green, blue))
        );
      });
    });
  
    describe('Normal cases (valid input)', () => {
      it('should return valid hexadecimal color when all input integers are valid and in range 0-255', () => {
        const validColors = [[0, 0, 0], [255, 255, 255], [255, 158, 170]];
        const expected = ['#000000', '#FFFFFF', '#FF9EAA'];
        validColors.forEach(([red, green, blue], i) => {
          assert.strictEqual(rgbToHexColor(red, green, blue), expected[i]);
        });
      });
    });
  });