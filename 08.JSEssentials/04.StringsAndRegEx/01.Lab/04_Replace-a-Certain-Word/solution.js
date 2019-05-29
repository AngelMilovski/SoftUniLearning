function solve() {
    let word = document.getElementById('word').value;
    let text = document.getElementById('text').value;
    let result = document.getElementById('result');

    if (word && text) {
        let arr = JSON.parse(text);
        let regex = new RegExp(`${arr[0].split(' ')[2]}`, 'gi');
        arr
            .map((str) => str.replace(regex, word))
            .forEach((el) => {
                let pElement = document.createElement('p');
                pElement.textContent = el;
                result.appendChild(pElement);
            });

            document.getElementById('word').value = '';
            document.getElementById('text').value = '';
    }
}