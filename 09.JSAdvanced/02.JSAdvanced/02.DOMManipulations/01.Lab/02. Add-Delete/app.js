function addItem() {
    const input = document.querySelector('#newText');
    
    if (input.value) {
        const text = input.value;
        input.value = '';
        const ulElement = document.querySelector('#items');
        const liElement = document.createElement('li');
        liElement.innerHTML = text + ' <a href="#">[Delete]</a>';
        liElement.children[0].addEventListener('click', remove);
        ulElement.appendChild(liElement);
    }

    function remove(evt) {
        const parent = evt.target.parentElement;
        parent.remove();
    }
}