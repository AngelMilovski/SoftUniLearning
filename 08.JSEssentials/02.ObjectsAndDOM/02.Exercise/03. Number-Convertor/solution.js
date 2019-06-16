function solve() {
    let select = document.querySelector('#selectMenuTo');
    let binary = document.createElement('option');
    binary.setAttribute('value', 'binary');
    binary.textContent = 'Binary';
    let hexadecimal = document.createElement('option');
    hexadecimal.setAttribute('value', 'hexadecimal');
    hexadecimal.textContent = 'Hexadecimal';
    select.appendChild(binary);
    select.appendChild(hexadecimal);

    document.querySelector('button').addEventListener('click', convert);

    function convert() {
        let input = document.getElementById('input').value;
        if (input) {
            let decimal = +input;
            let result = '';
            if (select.value === 'binary') {
                result = decimal.toString(2);
            } else if (select.value === 'hexadecimal') {
                result = decimal.toString(16).toLocaleUpperCase();
            }

            document.getElementById('result').setAttribute('value', `${result}`);
        }
    }
}