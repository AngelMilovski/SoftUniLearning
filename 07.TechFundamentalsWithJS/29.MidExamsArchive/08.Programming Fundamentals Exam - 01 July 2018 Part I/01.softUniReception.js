function solve(params) {
    let answeredStudentsPerHour = +params[0] + (+params[1]) + (+params[2]);
    let allStudents = +params[3];
    let sum = 0;
    let totalTime = 0;
    
    while (sum < allStudents) {
        totalTime += 1;
        if (totalTime % 4 === 0) {
            continue;
        }
        sum += answeredStudentsPerHour;
    }

    console.log(`Time needed: ${totalTime}h.`);
}

solve(['3', '2', '5', '40']);