function studentInformation(name, age, averageGrade) {
    return `Name: ${name}, Age: ${age}, Grade: ${averageGrade.toFixed(2)}`;
}

const result = studentInformation('John', 15, 5.54678);
console.log(result);