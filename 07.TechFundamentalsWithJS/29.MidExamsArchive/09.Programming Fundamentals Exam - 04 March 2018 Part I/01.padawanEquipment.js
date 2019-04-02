function solve(params) {
    let amountOfMoney = +params[0];
    let students = +params[1];
    let tenPercentOfStudents = Math.ceil(students + students / 100 * 10);
    let sabres = tenPercentOfStudents * +params[2];
    let robes = students * +params[3];
    let freeBelts = (students - parseInt(students / 6));
    let belts = freeBelts * +params[4];
    let neededMoney = sabres + robes + belts;

    if (neededMoney > amountOfMoney) {
        console.log(`Ivan Cho will need ${(neededMoney - amountOfMoney).toFixed(2)}lv more.`);
    } else {
        console.log(`The money is enough - it would cost ${neededMoney.toFixed(2)}lv.`);
    }
}

solve(['100', '42', '12.0', '4.0', '3.0']);