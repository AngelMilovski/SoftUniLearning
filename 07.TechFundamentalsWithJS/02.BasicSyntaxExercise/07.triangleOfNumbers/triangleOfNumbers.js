function solve(input) {
    const end = +input;
    for (let i = 1; i <= end; i++) {
        let number = i;
        console.log((`${number} `).repeat(i));
    }
}
solve(3);