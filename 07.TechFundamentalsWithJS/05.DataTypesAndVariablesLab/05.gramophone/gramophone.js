function gramophone(firstStr, secondStr, thirdStr) {
    let [nameOfTheBand, nameOfTheAlbum, nameOfTheSong] = [firstStr, secondStr, thirdStr];
    const fullRotation = 2.5;
    let durationInSec = (nameOfTheBand.length * nameOfTheAlbum.length) * nameOfTheSong.length / 2;
    let sum = Math.ceil(durationInSec / fullRotation);
    console.log(`The plate was rotated ${sum} times.`);
}

gramophone('Black Sabbath', 'Paranoid', 'War Pigs');