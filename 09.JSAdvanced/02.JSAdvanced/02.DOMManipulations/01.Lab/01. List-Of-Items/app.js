function addItem() {
    const input = document.querySelector('#newItemText');
    const ulElement = document.querySelector('#items');
    const liTemplate = document.querySelector('#items li');
    if (input.value) {
        const text = input.value;
        input.value = '';
        const liElement = liTemplate.cloneNode(true);
        liElement.innerHTML = text;
        ulElement.appendChild(liElement);
    }
}