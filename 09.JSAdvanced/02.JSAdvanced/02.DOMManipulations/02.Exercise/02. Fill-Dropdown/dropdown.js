function addItem() {
    const selectors = {
        menu: '#menu',
        text: '#newItemText',
        value: '#newItemValue'
    };
    const optionTemplate = document.createElement('option');

    const menu = document.querySelector(selectors.menu);
    const inputText = document.querySelector(selectors.text);
    const inputValue = document.querySelector(selectors.value);

    if (inputText && inputValue) {
        const text = inputText.value;
        const value = inputValue.value;
        inputText.value = '';
        inputValue.value = '';
        const option = createOption(text, value);
        menu.appendChild(option);
    }

    function createOption(text, value) {
        const option = optionTemplate.cloneNode(false);
        option.value = value;
        option.textContent = text;
        return option;
    }
}