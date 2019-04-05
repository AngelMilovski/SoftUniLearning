function movie(params) {
    let filmList = [];

    for (let i = 0; i < params.length; i++) {
        const inputLine = params[i].split(' ');

        if (inputLine.includes('add')) {

            let line = params[i].split(' movie ');
            addMovie(line[1]);
        } else if (inputLine.includes('directed')) {
            let [movie, director] = params[i].split(' directed by ');
            addDirector(movie, director);
        } else if (inputLine.includes('on')) {
            let [movie, date] = params[i].split(' on date ');
            addDate(movie, date);
        }
    }

    printMovies(filmList);


    function addMovie(name) {
        let foundedMovie = filmList.find((m) => m.name === name);
        if (foundedMovie == undefined) {
            filmList.push({
                name: name
            });
        }
    }

    function addDirector(movieName, director) {
        let foundedMovie = filmList.find((m) => m.name === movieName);
        if (foundedMovie != undefined) {
            foundedMovie.director = director;
        }
    }

    function addDate(movieName, date) {
        let foundedMovie = filmList.find((m) => m.name === movieName);
        if (foundedMovie != undefined) {
            foundedMovie.date = date;
        }
    }

    function printMovies(movies) {
        movies
        .filter((m) => {
            return (m.name != undefined && m.director != undefined && m.date != undefined);
        })
        .forEach(m => console.log(JSON.stringify(m)));
    }

}

movie([
    'add movie Fast and Furious',
    'add movie Godfather',
    'Inception directed by Christopher Nolan',
    'Godfather directed by Francis Ford Coppola',
    'Godfather on date 29.07.2018',
    'Fast and Furious on date 30.07.2018',
    'Batman on date 01.08.2018',
    'Fast and Furious directed by Rob Cohen'
]);