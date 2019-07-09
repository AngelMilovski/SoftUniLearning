function validate() {
    const inputEl = document.querySelector('input');
    inputEl.addEventListener('change', updateValue);

    function updateValue(evt) {
        const value = evt.target.value;
        validate(value);
    }

    function validate(email) {
        const arrOfEmail = email.split('');
        let name = false;
        let domain = false;
        let extension = false;

        if (arrOfEmail.includes('@')) {
            const index = arrOfEmail.indexOf('@');
            const nameLetters = arrOfEmail.slice(0, index);
            if (nameLetters.length &&
                nameLetters.every(ch => isLetter(ch)) &&
                nameLetters.every(l => isSmallLetter(l))) {
                name = true;
            }

            const secondEmailPart = arrOfEmail.slice(index + 1);
            if (secondEmailPart.includes('.')) {
                const index = secondEmailPart.indexOf('.');
                const domainLetters = secondEmailPart.slice(0, index);
                if (domainLetters.length &&
                    domainLetters.every(ch => isLetter(ch)) &&
                    domainLetters.every(l => isSmallLetter(l))) {
                    domain = true;
                }

                const extensionLetters = secondEmailPart.slice(index + 1);
                if (extensionLetters.length &&
                    extensionLetters.every(ch => isLetter(ch)) && 
                    extensionLetters.every(l => isSmallLetter(l))) {
                    extension = true;
                }
            }
        }

        if (name && domain && extension) {
            inputEl.classList.remove('error');
        } else {
            inputEl.className = 'error';
        }
    }

    function isLetter(ch) {
        return ch.toLowerCase() !== ch.toUpperCase();
    }

    function isSmallLetter(letter) {
        return letter == letter.toLowerCase();
    }
}