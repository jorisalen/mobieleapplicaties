package com.example.vasq.dekikkersprong.src.db;

import java.util.HashMap;

/**
 * Created by vasQ on 11/05/2015.
 */
public class GeheugenDatabase implements Database{
    HashMap<String,String> kinderen = new HashMap<>();

    public GeheugenDatabase() {
        kinderen.put("Key1","Wouter");
        kinderen.put("Key2","Joris");
        kinderen.put("Key3","Boeber");
    }

    @Override
    public HashMap<String, String> toonOverzicht() {
        return kinderen;
    }
}
