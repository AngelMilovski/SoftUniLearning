function stopwatch() {
    const time = document.querySelector('#time');
    const { startBtn, stopBtn } = getBtns();
    let seconds = 0;
    let tInterval;

    function start() {
        time.innerHTML = '00:00';
        tInterval = setInterval(getShowTime, 1000);
        startBtn.disabled = true;
        stopBtn.disabled = false;
    }

    function stop() {
        clearInterval(tInterval);
        startBtn.disabled = false;
        stopBtn.disabled = true;
    }

    function getShowTime() {
        seconds += 1;
        let min = (Math.floor(seconds / 60)).toString().padStart(2, '0');
        let sec = (seconds % 60).toString().padStart(2, '0');
        time.innerHTML = `${min}:${sec}`;
    }

    function getBtns() {
        const startBtn = document.querySelector('#startBtn');
        const stopBtn = document.querySelector('#stopBtn');
        startBtn.addEventListener('click', start);
        stopBtn.addEventListener('click', stop);

        return {
            startBtn,
            stopBtn
        };
    }
}
