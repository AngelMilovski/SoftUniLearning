function squareOfStars(params) {
    let n = +params || 5;
    for (let i = 0; i < n; i++) {
        console.log('* '.repeat(n).trim()); 
    }
}

squareOfStars(19);