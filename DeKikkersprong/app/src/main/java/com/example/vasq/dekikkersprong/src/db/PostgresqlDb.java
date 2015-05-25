package com.example.vasq.dekikkersprong.src.db;

import android.os.StrictMode;
import android.widget.Toast;

import com.example.vasq.dekikkersprong.src.domain.Kind;
import com.example.vasq.dekikkersprong.src.domain.Verblijf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
/**
 * Created by jalen on 5/21/2015.
 */
public class PostgresqlDb implements Database {

    Connection dbConnection = null;

    public PostgresqlDb(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://193.191.187.13:11124/DeKikkersprong",
                   "soniqdb", pass);
            dbConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String isConnected(){
        if(dbConnection != null){
            return "Geconnect";
        }
        return  "Niet geconnect";
    }

    @Override
    public boolean klokIn(int kindId) {
        boolean ok = false;
            try {
                PreparedStatement klokIn = dbConnection
                        .prepareStatement("INSERT INTO verblijven (kindId, tijdin, tijduit) VALUES(1,now(), null);");
                klokIn.setInt(1, kindId);
                klokIn.executeUpdate();
                klokIn.close();
                ok = true;

            } catch (SQLException e) {
            }
            return ok;

        }

    public boolean klokUit(int kindId) {
        boolean ok = false;
        try {
            PreparedStatement klokUit = dbConnection
                    .prepareStatement("update verblijven set tijduit = now() WHERE kindId = ? and tijduit is null;");
            klokUit.setInt(1, kindId);
            klokUit.executeUpdate();
            klokUit.close();
            ok = true;
        } catch (SQLException e) {
        }
        return ok;

    }


    public HashMap<String, Verblijf> toonOverzicht(int kindId) {
        HashMap<String, Verblijf> overzicht = null;
        try {
            PreparedStatement getOverzicht = dbConnection
                    .prepareStatement("select * from Verblijven where kindId = ?");
            getOverzicht.setInt(1, kindId);
            ResultSet result = getOverzicht.executeQuery();

            if(result.next()){
                overzicht = convertToHashmap(result);
            }else{
            }
        } catch (SQLException e) {
        }
        return overzicht;

    }

    private HashMap<String, Verblijf> convertToHashmap(ResultSet result) {
        HashMap<String, Verblijf> overzicht = null;
        try {
            while (result.next()){
                overzicht.put(result.getString("id"),convertToVerblijf(result));
            }
        } catch (SQLException e) {
        }
        return overzicht;
    }


    public Kind getKind(int id){
         Kind kind = null;
            try {
               PreparedStatement getKind = dbConnection
                                .prepareStatement("select * from Kinderen where id = ?");
               getKind.setInt(1, id);
               ResultSet result = getKind.executeQuery();

               if(result.next()){
                  kind = convertToKind(result);
               }else{
            }
        } catch (SQLException e) {
        }
        return kind;
    }

    public Verblijf getVerblijf(int kindId){
        Verblijf verblijf = null;
        try {
            PreparedStatement getVerblijf = dbConnection
                    .prepareStatement("select * from Verblijven where kindId = ?");
            getVerblijf.setInt(1, kindId);
            ResultSet result = getVerblijf.executeQuery();

            if(result.next()){
                verblijf = convertToVerblijf(result);
            }else{
            }
        } catch (SQLException e) {
        }
        return verblijf;
    }

    public Verblijf convertToVerblijf(ResultSet result) {
        Verblijf verblijf = null;
        //TODO hoofdingen checken
        try {
            verblijf = new Verblijf(result.getInt("kindId"), result.getTimestamp("tijdIn"), result.getTimestamp("tijdUit"));
        } catch (SQLException e) {
        }
        return verblijf;

    }

    private Kind convertToKind(ResultSet result) {
        Kind kind = null;
        //TODO hoofdingen checken
        try {
            kind = new Kind(result.getString("naam"), result.getString("voornaam"),
                    result.getInt("id"));
        } catch (SQLException e) {
        }
        return kind;
    }


//    voorbeeld : https://github.com/woutervandamme/FlashCardDomain/blob/master/src/db/MySQLDatabase.java
//    private ArrayList<User> convertToUserList(ResultSet result) throws DBException{
//        ArrayList<User> users = new ArrayList<User>();
//        try {
//            while (result.next()) {
//                users.add(getUser(result.getString("UserID")));
//            }
//        } catch (SQLException e) {
//            throw new DBException("user to list convertion went wrong",e);
//        }
//        return users;
//    }


    private String pass = "joris";

}
