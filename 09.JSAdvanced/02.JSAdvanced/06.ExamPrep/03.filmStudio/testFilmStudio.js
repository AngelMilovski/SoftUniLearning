const FilmStudio = require('./filmStudio');
const { expect } = require('chai');

describe('FilmStudio', () => {
    let filmStudio;
    beforeEach('createInstance', () => {
        filmStudio = new FilmStudio('SU-Studio');
    });

    describe('Testing constructor', () => {
        it('Constructor should have 2 properties', () => {
            expect(filmStudio).to.has.property('name');
            expect(filmStudio).to.has.property('films');
        });

        it('A string argument should representing the film studio name', () => {
            const testingResult = filmStudio.name;
            expect(testingResult).to.be.equals('SU-Studio');
        });

        it('Films property should be initialized as empty array', () => {
            expect(filmStudio.films).to.deep.equal([]);
        });
    });

    describe('Testing makeMovie function', () => {
        it('If length of the arguments are less tha 2 throw error', () => {
            const filmName = 'Game of thrones';
            const badFn = () => {
                filmStudio.makeMovie(filmName);
            };

            expect(badFn).to.throw('Invalid arguments count');
        });

        it('If arguments are in invalid type should throw error', () => {
            const filmName = 23;
            const roles = 'Hulk';
            const badFn = () => {
                filmStudio.makeMovie(filmName, roles);
            };
            
            expect(badFn).to.throw('Invalid arguments');
        });

        it('If current film do not exists make current film', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Hulk', 'Arrow guy'];
            const testFilm = filmStudio.makeMovie(filmName, roles);
            expect(testFilm).to.be.an('object').that.has.all.keys('filmName', 'filmRoles');
            expect(testFilm.filmName).to.be.equal('The Avengers');
            expect(testFilm.filmRoles).to.be.an('array');
        });

        it('The film roles should be array with all roles', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Hulk', 'Arrow guy'];
            const testFilm = filmStudio.makeMovie(filmName, roles);
            testFilm.filmRoles.forEach((movie, i) => {
                expect(movie.role).to.be.equal(roles[i]);
            });
        });

        it('The movie already exist make a sequel', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Hulk', 'Arrow guy'];
            const array = [2, 3, 4, 5];
            filmStudio.makeMovie(filmName, roles);
            array.forEach((number) => {
                const expectedResult = `The Avengers ${number}`;
                const testFilm = filmStudio.makeMovie(filmName, roles);
                const testingResult = testFilm.filmName;
                expect(testingResult).to.be.equals(expectedResult);
            });
        });
    });

    describe('Testing casting function', () => {
        it('The studio there is no current film should said the film doesn\'t exist', () => {
            const testingResult = filmStudio.casting('Peter', 'Hulk');
            const expectedResult = 'There are no films yet in SU-Studio.';
            expect(testingResult).to.be.equal(expectedResult);
        });

        it('If everything is OK should employed current actor', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Hulk', 'Arrow guy'];
            filmStudio.makeMovie(filmName, roles);
            const testingResult = filmStudio.casting('Peter', 'Hulk');
            const expectedResult = 'You got the job! Mr. Peter you are next Hulk in the The Avengers. Congratz!';
            expect(testingResult).to.be.equal(expectedResult);
        });

        it('If the role does not exist should return the role doesn\'t exist', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Arrow guy'];
            filmStudio.makeMovie(filmName, roles);
            const testingResult = filmStudio.casting('Peter', 'Hulk');
            const expectedResult = 'Peter, we cannot find a Hulk role...';
            expect(testingResult).to.be.equal(expectedResult);
        });
    });

    describe('Testing lookForProducer function', () => {
        it('If current film exist print its info', () => {
            const filmName = 'The Avengers';
            const roles = ['Iron-Man', 'Thor', 'Arrow guy'];
            filmStudio.makeMovie(filmName, roles);
            const testingResult = filmStudio.lookForProducer('The Avengers');
            const expectedResult = 'Film name: The Avengers\nCast:\nfalse as Iron-Man\nfalse as Thor\nfalse as Arrow guy\n';
            expect(testingResult).to.be.equal(expectedResult);
        });

        it('It current film does not exist throw error', () => {
            const badFn = () => {
                filmStudio.lookForProducer('The Avengers');
            };

            expect(badFn).to.throw('The Avengers do not exist yet, but we need the money...');
        });
    });
});