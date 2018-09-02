package online_radio_database;

import online_radio_database.exceptions.InvalidSongException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfSongs = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        while (countOfSongs-- > 0) {
            String[] songTokens = reader.readLine().split(";");

            try {
                Song song = new Song(songTokens[0], songTokens[1]);

                SongLength songLength = new SongLength(songTokens[2]);

                song.setSongLength(songLength);

                playlist.addSong(song);

                System.out.println("Song added.");

            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.println(String.format("Songs added: %d", playlist.getSongs().size()));
        System.out.println(playlist.getPlaylistLength());
    }
}