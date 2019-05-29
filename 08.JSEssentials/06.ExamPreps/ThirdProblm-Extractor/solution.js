function solve() {
    let extractBtn = document.querySelector('button');
    extractBtn.addEventListener('click', extract);

    function extract() {
        let input = document.getElementById('input').value;
        let output = document.getElementById('output');

        if (input) {
            let str = input;
            let number = str.match(/\d+/)[0];
            str = str.substring(number.length);
            str = str.substring(0, +number);
            let splitter = str[str.length - 1];
            let arr = str.split(splitter);
            let pattern = `[^${arr[0]}]`;
            let text = arr[1]
                .match(new RegExp(pattern, 'g'))
                .map(ch => ch === '#' ? ' ' : ch)
                .join('');
            output.textContent = text;
            document.getElementById('input').value = '';
        }
    }
}