function passwordValidator(input) {
    const password = input;
    const validationForLengthOfPassword = function checkForLengthOfPassword(pass) {
        if (pass.length >= 6 && pass.length <= 10) {
            return true;
        }

        return false;
    };

    const validationForDigitsAndLetter = function checkForDigitsAndLetter(pass) {
        const digitsAndLettersRegex = /^[A-Za-z0-9]+$/;
        if (digitsAndLettersRegex.test(pass)) {
            return true;
        }

        return false;
    };

    const validationForAtLeastTwoDigits = function checkForAtLeastTwoDigits(pass) {
        const digitsRegex = /\d{2}/;
        if (digitsRegex.test(pass)) {
            return true;
        }

        return false;
    };

    const validatedCheckForLength = validationForLengthOfPassword(password);
    const validatedCheckForDigitsAndLetters = validationForDigitsAndLetter(password);
    const validatedCheckForAtLeastTwoDigits = validationForAtLeastTwoDigits(password);

    if (!validatedCheckForLength) {
        console.log('Password must be between 6 and 10 characters');
    }
    if (!validatedCheckForDigitsAndLetters) {
        console.log('Password must consist only of letters and digits');
    }
    if (!validatedCheckForAtLeastTwoDigits) {
        console.log('Password must have at least 2 digits');
    }
    if (validatedCheckForLength && validatedCheckForDigitsAndLetters && validatedCheckForAtLeastTwoDigits) {
        console.log('Password is valid');
    }
}

passwordValidator('MyPass123');
passwordValidator('logIn');
passwordValidator('Pa$s$s');