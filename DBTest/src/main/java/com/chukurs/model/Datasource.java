package com.chukurs.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/mc/IdeaProjects/DBTest/src/main/resources/" + DB_NAME;

    //
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARIST = "artist";
    public static final int INDEX_ALBUM_ID =1;
    public static final int INDEX_ALBUM_NAME=2;
    public static final int INDEX_ALBUM_ARTIST = 3;
    //
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;
    //
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID =1;
    public static final int INDEX_SONG_TRACK =2;
    public static final int INDEX_SONG_TITLE =3;
    public static final int INDEX_SONG_ALBUM =4;

    //

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("There's a problem with opening: ");
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("There's a problem with closing: ");
            System.out.println(e.getMessage());
        }
    }

public List<Artist> queryArtists(){

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM "+ TABLE_ARTISTS)){

            List<Artist> artists = new ArrayList<>();
            while(results.next()){
                Artist artist = new Artist();
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        }
        catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

}

}
