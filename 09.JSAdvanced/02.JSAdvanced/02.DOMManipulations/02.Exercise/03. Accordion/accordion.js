function toggle() {
    const divEl = document.querySelector('#extra');
    const btn = document.querySelector('.button');

    if (btn.textContent === 'More') {
        divEl.style.display = 'block';
        btn.textContent = 'Less';
    } else if (btn.textContent === 'Less') {
        divEl.style.display = 'none';
        btn.textContent = 'More';
    }
}