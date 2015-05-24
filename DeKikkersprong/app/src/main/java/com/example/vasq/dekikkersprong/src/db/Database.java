package com.example.vasq.dekikkersprong.src.db;

import java.util.HashMap;

/**
 * Created by vasQ on 11/05/2015.
 */
public interface Database {


    public HashMap<String, String> toonOverzicht();
    public boolean isConnected();

}
