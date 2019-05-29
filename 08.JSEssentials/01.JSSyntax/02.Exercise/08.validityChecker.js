function validityChecker(params) {
    let x1 = +params[0];
    let y1 = +params[1];
    let x2 = +params[2];
    let y2 = +params[3];
    if (distance(x1, y1, 0, 0) % 1 === 0) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);

    if (distance(x2, y2, 0, 0) % 1 === 0) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);

    if (distance(x1, y1, x2, y2) % 1 === 0) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);


    function distance(x1, y1, x2, y2) {
        let p1 = (x2 - x1) ** 2;
        let p2 = (y2 - y1) ** 2;
        return Math.sqrt(p1 + p2);
    }
}

validityChecker([3, 0, 0, 4]);
// p(x2 − x1)2 + (y2 − y1)2