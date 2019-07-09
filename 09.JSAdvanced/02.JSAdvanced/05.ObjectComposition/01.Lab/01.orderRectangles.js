function orderRectangles(params) {
    let obj = {
        width: 0,
        height: 0,
        area: function () {
            return this.width * this.height;
        },
        compareTo: function (another) {
            let currArea = this.area();
            let anotherArea = another.area();
            let result = anotherArea - currArea;
            if (result === 0) {
                const currWidth = this.width;
                const nextWidth = another.width;
                result = nextWidth - currWidth;
            }
            return result;
        }
    };

    return params
        .reduce((acc, cur) => {
            const [width, height] = cur;
            const rectangle = Object.create(obj);
            rectangle.width = width;
            rectangle.height = height;
            acc.push(rectangle);
            return acc;
        }, [])
        .sort((a, b) => {
            let result = a.compareTo(b);
            return result;
        });
}

console.log(orderRectangles([[1, 20], [20, 1], [5, 3], [5, 3]]));