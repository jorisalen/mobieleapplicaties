package com.example.vasq.dekikkersprong.src.db;

import com.example.vasq.dekikkersprong.src.domain.Verblijf;

import java.util.HashMap;

/**
 * Created by vasQ on 11/05/2015.
 */
public interface Database {


    public HashMap<String, Verblijf> toonOverzicht(int kindId);
    public String isConnected();

    public boolean klokIn(int kindId);
    public boolean klokUit(int kindId);
}
