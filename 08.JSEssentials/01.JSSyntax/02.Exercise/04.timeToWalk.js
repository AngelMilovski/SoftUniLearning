function timeToWalk(firstArg, secondArg, thirdArg) {
    let distanceInMeters = firstArg * secondArg;
    let studentSpeed = thirdArg / 3.60;
    let restsInSeconds = Math.floor(distanceInMeters / 500) * 60;
    let timeInSeconds = distanceInMeters / studentSpeed + restsInSeconds;
    let hours = Math.floor(timeInSeconds / (60 * 60));
    let minutes = Math.floor(timeInSeconds / 60);
    let seconds = Math.round(timeInSeconds % 60);
    hours = (hours < 10) ? ('0' + hours) : hours;
    minutes = (minutes < 10) ? ('0' + minutes) : minutes;
    seconds = (seconds < 10) ? ('0' + seconds) : seconds;
    return `${hours}:${minutes}:${seconds}`;
}

console.log(timeToWalk(2564, 0.70, 5.5));