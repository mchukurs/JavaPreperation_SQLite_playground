package com.chukurs;
import com.chukurs.model.Artist;
import com.chukurs.model.Datasource;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            String url = "jdbc:sqlite:/home/mc/IdeaProjects/DBTest/src/main/resources/testjava.db";
//            Connection conn = DriverManager.getConnection(url);
//            //conn.setAutoCommit(false);
//            Statement statement = conn.createStatement();
////            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
////                                 "(name TEXT, phone INTEGER, email TEXT)");
////
////            statement.execute("INSERT INTO contacts (name, phone,email)" +
////                                 "VALUES('Dog',43343109,'Dog@mail.au')");
////
////            statement.execute("INSERT INTO contacts (name, phone,email)" +
////                    "VALUES('Jane',878965,'Jane@foxmail.com')");
////
//          //  statement.execute("DELETE FROM contacts WHERE name = 'John'");
//
////            statement.execute("UPDATE contacts SET phone= '696955555555555'" +
////                                 "WHERE name = 'Jane'");
//            statement.execute("SELECT * FROM contacts");
//           ResultSet results = statement.getResultSet();
//
//           while(results.next()){
//               System.out.println(results.getString("name")+" "+
//                                  results.getInt("phone")+" "+
//                                  results.getString("email"));
//           }
//            results.close();
//            statement.close();
//            conn.close();
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        Datasource ds = new Datasource();

        if(!ds.open()){
            System.out.println("Cannot open datasource!");
            return;
        }

        List<Artist> myArtists = ds.queryArtists();
        if(myArtists == null){
            System.out.println("Artists is null! ");
            return;
        }
        for(Artist art: myArtists){
            System.out.println("ID: "+art.getId()+"\n"+"Name: "+art.getName()+"\n");
        }


        ds.close();
    }

}
