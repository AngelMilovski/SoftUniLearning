function focus() {
    
    (function addEvents(evt) {
        const inputEls = Array.from(document.querySelectorAll('input'));
        inputEls.forEach(input => input.addEventListener('focus', focusEvent));
        inputEls.forEach(input => input.addEventListener('blur', blurEvent));
    })();

    function focusEvent(evt) {
        const element = evt.target;
        const parent = element.parentElement;
        parent.className = 'focused';
    }

    function blurEvent(evt) {
        const element = evt.target;
        const parent = element.parentElement;
        parent.classList.remove('focused');
    }
}