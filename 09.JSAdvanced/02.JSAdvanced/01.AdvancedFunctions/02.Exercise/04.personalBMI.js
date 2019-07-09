function personalBMI(name, age, weight, height) {
    const BMI = calculateBmi();
    let person = {
        name,
        personalInfo: {
            age,
            weight,
            height
        },
        BMI,
    };

    let status = '';
    if (BMI < 18) {
        status = 'underweight';
    } else if (BMI >= 18 && BMI < 25) {
        status = 'normal';
    } else if (BMI >= 25 && BMI < 30) {
        status = 'overweight';
    } else {
        status = 'obese';
    }

    if (status === 'obese') {
        person.recommendation = 'admission required';
    }

    person.status = status;

    return person;

    function calculateBmi() {
        return Math.round(weight / (height ** 2) * 10000);
    }
}

console.log(personalBMI('Peter', 29, 75, 182));