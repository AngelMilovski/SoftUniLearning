function addAndRemoveElementsFromArray(input) {
    let result = [];
    let number = 1;

    input.forEach((command) => {
        if(command == "add") {
            result.push(number);
        } else {
            result.pop();
        }

        number++;
    });

    if(result.length === 0) {
        console.log("Empty");
    } else {
        result.forEach(element => console.log(element));
    }
}