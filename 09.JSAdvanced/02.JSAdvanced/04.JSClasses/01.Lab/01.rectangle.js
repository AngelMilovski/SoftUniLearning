class Rectangle {
    constructor(width, height, color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    get width() {
        return this._width;
    }

    set width(width) {
        if (!isNaN(width)) {
            this._width = +width;
        }
    }

    get height() {
        return this._height;
    }

    set height(height) {
        if (!isNaN(height)) {
            this._height = +height;
        }
    }

    calcArea() {
        return this.width * this.height;
    }
}

let rect = new Rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());