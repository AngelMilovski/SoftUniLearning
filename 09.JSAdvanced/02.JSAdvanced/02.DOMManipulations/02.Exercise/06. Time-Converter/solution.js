function attachEventsListeners() {
    const btns = Array.from(document.querySelectorAll('input[type="button"]'));
    btns.map(btns => btns.addEventListener('click', convert));

    let fields = {
        days: document.querySelector('#days'),
        hours: document.querySelector('#hours'),
        minutes: document.querySelector('#minutes'),
        seconds: document.querySelector('#seconds')
    };

    function convert() {
        const field = getNonEmptyInput();

        if (field) {
            const number = +field[1].value;
            let days, hours, minutes, seconds;

            switch (field[0]) {
                case 'days':
                    days = number;
                    hours = days * 24;
                    minutes = hours * 60;
                    seconds = minutes * 60;
                    break;

                case 'hours':
                    hours = number;
                    days = hours / 24;
                    minutes = hours * 60;
                    seconds = minutes * 60;
                    break;

                case 'minutes':
                    minutes = number;
                    hours = minutes / 60;
                    days = hours / 24;
                    seconds = minutes * 60;
                    break;

                case 'seconds':
                    seconds = number;
                    minutes = number / 60;
                    hours = minutes / 60;
                    days = hours / 24;
                    break;
            }

            fields.days.value = days;
            fields.hours.value = hours;
            fields.minutes.value = minutes;
            fields.seconds.value = seconds;
        }
    }

    function getNonEmptyInput() {
        const any = Object
            .entries(fields)
            .find(inp => inp[1].value !== '');

        return any;
    }
}
