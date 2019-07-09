function encodeAndDecodeMessages() {
    const encodedBtn = document.querySelector('#main button');
    const decodedBtn = document.querySelectorAll('#main button')[1];
    encodedBtn.addEventListener('click', encodedMassage);
    decodedBtn.addEventListener('click', decodedMassage);

    const encodedField = document.querySelectorAll('textarea')[0];
    const decodedField = document.querySelectorAll('textarea')[1];

    function encodedMassage() {
        let text = encodedField.value;
        if (text) {
            encodedField.value = '';
            text = text
                .split('')
                .map(ch => String.fromCharCode(ch.charCodeAt(0) + 1))
                .join('');
            decodedField.value = text;
            decodedBtn.disabled = false;
        }
    }

    function decodedMassage() {
        let text = decodedField.value;
        if (text) {
            text = text
                .split('')
                .map(ch => String.fromCharCode(ch.charCodeAt(0) - 1))
                .join('');
            decodedField.value = text;
            decodedBtn.disabled = true;
        }
    }
}