function solve(params) {
    let courses = params.shift().split(', ');
    params.pop();

    for (const line of params) {
        let data = line.split(':');
        let command = data[0];
        let lessonTitle = data[1];
        let index = courses.indexOf(lessonTitle);
        let exercise = `${lessonTitle}-Exercise`;
        switch (command) {
            case 'Add':
                if (index < 0) {
                    courses.push(lessonTitle);
                }
                break;

            case 'Insert':
                let neededIndex = +data[2];
                if (index < 0 && neededIndex >= 0 && neededIndex < courses.length) {
                    courses.splice(neededIndex, 0, lessonTitle);
                }
                break;

            case 'Remove':
                if (index > -1) {
                    courses.splice(index, 1);
                }
                index = courses.indexOf(exercise);
                if (index > -1) {
                    courses.splice(index, 1);
                }
                break;

            case 'Swap':
                let nextLessonTitle = data[2];
                let nextExercise = `${nextLessonTitle}-Exercise`;
                let nextIndex = courses.indexOf(nextLessonTitle);
                if (index > -1 && nextIndex > -1) {
                    courses.splice(index, 1, nextLessonTitle);
                    courses.splice(nextIndex, 1, lessonTitle);
                    if (courses.indexOf(nextExercise) > -1) {
                        courses.splice(courses.indexOf(nextExercise), 1);
                        courses.splice(index + 1, 0, nextExercise);
                    }
                    if (courses.indexOf(exercise) > -1) {
                        courses.splice(courses.indexOf(exercise), 1);
                        courses.splice(nextIndex + 1, 0, exercise);
                    }
                }
                break;

            case 'Exercise':
                if (index > -1) {
                    if (!courses.includes(exercise)) {
                        courses.splice(index + 1, 0, exercise);
                    }
                } else {
                    courses.push(lessonTitle);
                    courses.push(exercise);
                }
                break;
        }
    }

    courses.forEach((v, i) => console.log(i + 1 + '.' + v));
}

solve([
    'Arrays, Lists, Methods',
    'Swap:Arrays:Methods',
    'Exercise:Databases',
    'Swap:Lists:Databases',
    'Insert:Arrays:0',
    'course start'
])

// solve([
//     'Data Types, Objects, Lists',
//     'Add:Databases',
//     'Insert:Arrays:0',
//     'Remove:Lists',
//     'course start'
// ]);