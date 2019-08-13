(function attachEvents() {
    const baseUrl = 'https://judgetests.firebaseio.com/locations.json';

    const elements = {
        location: document.querySelector('input[type="text"]'),
        forecast: document.querySelector('#forecast'),
        today: document.querySelector('#current'),
        upcoming: document.querySelector('#upcoming'),
        getWhether: document.querySelector('input[type="button"]')
    };

    const symbols = {
        'Sunny': '☀',
        'Partly sunny': '⛅',
        'Overcast': '☁',
        'Rain': '☂',
    };

    const handler = (res) => {
        if (res.status > 400) {
            throw new Error(`Error: ${res.status} (${res.statusText})`);
        }
        
        return res.json();
    };
    
    const throwError = (err) => {
        elements.forecast.innerHTML = 'Error';
        elements.forecast.style.display = 'block';
        elements.location.value = '';
        console.warn(err);
    };

    const info = [];
    fetch(baseUrl)
        .then(handler)
        .then(data => data.forEach(d => info.push(d)))
        .catch(throwError);

    const createHtmlElement = (tagName, className, textContent) => {
        const el = document.createElement(tagName);

        if (className) {
            el.className = className;
        } 

        if (textContent) {
            el.textContent = textContent;
        }

        return el;
    };

    const getWhetherToday = (data) => {
        const divForecasts = createHtmlElement('div', 'forecasts');
        const symbol = data.forecast.condition;
        const spanConditionSymbol = createHtmlElement('span', 'condition symbol', symbols[symbol]);
        const spanCondition = createHtmlElement('span', 'condition');
        const spanCityName = createHtmlElement('span', 'forecast-data', data.name);
        const degrees = `${data.forecast.low}°/${data.forecast.high}°`;
        const spanDegrees = createHtmlElement('span', 'forecast-data', degrees);
        const lastSpan = createHtmlElement('span', 'forecast-data', data.forecast.condition);
        
        
        divForecasts.appendChild(spanConditionSymbol);
        spanCondition.appendChild(spanCityName);
        spanCondition.appendChild(spanDegrees);
        spanCondition.appendChild(lastSpan);
        divForecasts.appendChild(spanCondition);
        elements.today.appendChild(divForecasts);
    };

    const getCurrentLocationCode = () => {
        const city = elements.location.value;
        const searchedCity = info.find(o => o.name === city);
        let code;
        if (searchedCity) {
            code = searchedCity.code;
        }

        return code;
    };

    const getWhetherForThreeDays = (data) => {
        const divUpcoming = createHtmlElement('div', 'forecast-info');
        data.forecast.forEach((info) => {
            const spanUpcoming = createHtmlElement('span', 'upcoming');
            const symbol = symbols[info.condition];
            const spanSymbol = createHtmlElement('span', 'symbol', symbol);
            const degrees = `${info.low}°/${info.high}°`;
            const spanDegrees = createHtmlElement('span', 'forecast-data', degrees);
            const spanCondition = createHtmlElement('span', 'forecast-info', info.condition);
            spanUpcoming.appendChild(spanSymbol);
            spanUpcoming.appendChild(spanDegrees);
            spanUpcoming.appendChild(spanCondition);
            divUpcoming.appendChild(spanUpcoming);
        });

        elements.upcoming.appendChild(divUpcoming);
    };

    const displayWhether = () => {
        elements.forecast.style.display = 'block';
    };

    const displayWhetherForThreeDays = () => {
        const code = getCurrentLocationCode();
        elements.location.value = '';

        fetch(`https://judgetests.firebaseio.com/forecast/upcoming/${code}.json`)
            .then(handler)
            .then(getWhetherForThreeDays)
            .then(displayWhether)
            .catch(throwError);
    };

    const clearWethers = () => {
        const forecasts = document.querySelector('div.forecasts');
        const forecastInfo = document.querySelector('div.forecast-info');
        elements.forecast.style.display = 'none';
        if (forecasts) {
            forecasts.remove();
        }

        if (forecastInfo) {
            forecastInfo.remove();
        }
    };

    const loadWhetherToday = () => {
        clearWethers();

        if (!elements.location.value) {
            return;
        }

        const code = getCurrentLocationCode();

        fetch(`https://judgetests.firebaseio.com/forecast/today/${code}.json`)
            .then(handler)
            .then(getWhetherToday)
            .then(displayWhetherForThreeDays)
            .catch(throwError);
    };

    elements.getWhether.addEventListener('click', loadWhetherToday);
}());
