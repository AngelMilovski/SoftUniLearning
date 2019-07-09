function attachGradientEvents() {
    const selectors = {
        input: '#gradient',
        result: '#result'
    };

    const elements = {
        inputEl: getTargetElement(),
        resultEl: getResultEl()
    };

    elements.inputEl = addEvents(elements.inputEl);
    console.log(elements.inputEl);

    function getPercent(evt) {
        const percent = Math.floor(evt.offsetX / evt.target.clientWidth * 100);
        printResult(percent);
    }

    function printResult(percent) {
        elements.resultEl.innerHTML = percent + '%';
    }

    function getResultEl() {
        return document.querySelector(selectors.result);
    }

    function getTargetElement() {
        return document.querySelector(selectors.input);
    }

    function addEvents(element) {
        element.addEventListener('mousemove', getPercent);
        element.addEventListener('mouseout', () => {
            elements.resultEl.innerHTML = '';
        });

        return element;
    }
}