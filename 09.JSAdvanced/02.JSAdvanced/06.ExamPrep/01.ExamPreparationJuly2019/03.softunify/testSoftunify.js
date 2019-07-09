const { expect } = require('chai');
const SoftUniFy = require('./03.softunify');

describe('SoftUniFy', () => {
    let sofunify;
    beforeEach(() => {
        sofunify = new SoftUniFy();
    });

    it('SoftUniFy should be an object whit empty property allSongs', () => {
        expect(sofunify).to.have.deep.property('allSongs', {});
    });

    describe('testing downloadSong', () => {
        it('allSongs should keep artist correctly', () => {
            sofunify.downloadSong('Eminem', 'Venom', 'Knock, Knock let the devil in...');
            sofunify.downloadSong('Eminem', 'Phenomenal', 'IM PHENOMENAL...');
            sofunify.downloadSong('Dub Fx', 'Light Me On Fire', 'You can call me a liar.. ');
            const artists = ['Eminem', 'Dub Fx'];
            Object
                .keys(sofunify.allSongs)
                .forEach((artist, i) => {
                    expect(artist).to.be.equal(artists[i]);
                });
        });

        it('songs property, should contain all songs from the current artist in format array', () => {
            sofunify.downloadSong('Eminem', 'Venom', 'Knock, Knock let the devil in...');
            sofunify.downloadSong('Eminem', 'Phenomenal', 'IM PHENOMENAL...');

            const correctFormat = [
                'Venom - Knock, Knock let the devil in...',
                'Phenomenal - IM PHENOMENAL...'
            ];
            Object
                .values(sofunify.allSongs)
                .forEach((value) => {
                    value.songs.forEach((song, i) => {
                        expect(song).to.be.equal(correctFormat[i]);
                    });
                });
        });
    });


    it('If we do not have at least one downloaded song should return message', () => {
        const song = 'Venom';
        const message = `You have not downloaded a ${song} song yet. Use SoftUniFy's function downloadSong() to change that!`;
        const result = sofunify.playSong(song);
        expect(result).to.be.equal(message);
    });

    it('Return song in correct format', () => {
        const song = 'Venom';
        sofunify.downloadSong('Eminem', 'Venom', 'Knock, Knock let the devil in...');
        const songList = 'Eminem:\nVenom - Knock, Knock let the devil in...\n';
        const result = sofunify.playSong(song);
        expect(result).to.be.equal(songsList);
    });

    it('songsList - gets all already downloaded songs correctly', () => {
        sofunify.downloadSong('Eminem', 'Venom', 'Knock, Knock let the devil in...');
        sofunify.downloadSong('Eminem', 'Phenomenal', 'IM PHENOMENAL...');
        sofunify.downloadSong('Dub Fx', 'Light Me On Fire', 'You can call me a liar.. ');
        const songs = sofunify.songsList;
        const songsList = 'Venom - Knock, Knock let the devil in...\nPhenomenal - IM PHENOMENAL...\nLight Me On Fire - You can call me a liar.. ';
        expect(songs).to.be.equal(songsList);
    });

    describe('Testing rateArtist', () => {
        it('If the given artist exist in allSongs should return average rate', () => {
            sofunify.downloadSong('Eminem', 'Phenomenal', 'IM PHENOMENAL...');
            const rate = sofunify.rateArtist('Eminem', 50);
            expect(rate).to.be.equal(50);
        });

        it('the given artist does not exist in allSongs should return message', () => {
            const message = 'The Eminem is not on your artist list.';
            const rate = sofunify.rateArtist('Eminem', 50);
            expect(rate).to.be.equal(message);
        });
    });
});