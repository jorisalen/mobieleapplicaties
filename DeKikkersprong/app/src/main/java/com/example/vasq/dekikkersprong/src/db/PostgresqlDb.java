package com.example.vasq.dekikkersprong.src.db;

import android.widget.Toast;

import com.example.vasq.dekikkersprong.src.domain.Kind;

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
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/de%20Kikkersprong",
                   "joris", "joris");
            dbConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public boolean isConnected(){
        if(dbConnection != null){
            return true;
        }
        return  false;
    }
    @Override
    public HashMap<String, String> toonOverzicht() {
        return null;
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


}
