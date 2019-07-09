class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

    static distance(point1, point2) {
        const horizontalDistance = point2.x - point1.x;
        const verticalDistance = point2.y - point1.y;
        const squareOfTwoDistance = Math.pow(horizontalDistance, 2) + Math.pow(verticalDistance, 2);
        const distanceBetweenTwoPoints = Math.sqrt(squareOfTwoDistance);
        return distanceBetweenTwoPoints;
    }
}

let p1 = new Point(5, 5);
let p2 = new Point(9, 8);
console.log(Point.distance(p1, p2));