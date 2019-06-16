function solve() {
    let text = document.getElementById('text').value;
    let count = +document.getElementById('number').value;
    let result = document.getElementById('result');
    if (text && count) {
        let arr = [];
        let indexCounter = 0;
        if (text.length % count !== 0) {
            let len = text.length;
            let symbolCount = 0;

            while (len % count !== 0) {
                len %= count;
                len += 1;
                symbolCount += 1;
            }

            for (let i = 0; i < symbolCount; i++) {
                text += text[indexCounter];
                indexCounter++;
            }
        }

        for (let i = 0; i < text.length; i += count) {
            arr.push(text.substr(i, count));
        }
        result.textContent = arr.join(' ');
    }

    document.getElementById('text').value = '';
    document.getElementById('number').value = '';
}