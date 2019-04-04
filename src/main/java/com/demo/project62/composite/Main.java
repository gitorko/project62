package com.demo.project62.composite;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

public class Main {

    public static void main(String[] args) {
        SongComponent playlist1 = new PlayList("playlist_1");
        SongComponent playlist2 = new PlayList("playlist_2");
        SongComponent playlist3 = new PlayList("playlist_3");
        SongComponent myplaylist = new PlayList("myplaylist");
        myplaylist.add(playlist1);
        myplaylist.add(playlist2);
        playlist1.add(new Song("Song1"));
        playlist1.add(new Song("Song2"));
        playlist1.add(playlist3);
        playlist3.add(new Song("Song3"));

        myplaylist.displaySongInfo();
    }
}

abstract class SongComponent {

    public void add(SongComponent c) {
        throw new UnsupportedOperationException();
    }

    public String getSong() {
        throw new UnsupportedOperationException();
    }

    public void displaySongInfo() {
        throw new UnsupportedOperationException();
    }
}

@RequiredArgsConstructor
class PlayList extends SongComponent {

    final String playListName;
    List<SongComponent> componentLst = new ArrayList<>();

    @Override
    public void add(SongComponent c) {
        componentLst.add(c);
    }

    @Override
    public void displaySongInfo() {
        System.out.println("Playlist Name: " + playListName);
        for (SongComponent s : componentLst) {
            s.displaySongInfo();
        }
    }
}

@AllArgsConstructor
class Song extends SongComponent {
    String songName;

    @Override
    public String getSong() {
        return songName;
    }

    @Override
    public void displaySongInfo() {
        System.out.println("Song: " + songName);
    }
}