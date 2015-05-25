package com.example.vasq.dekikkersprong.src.facade;

import java.util.Date;
import java.util.HashMap;

import com.example.vasq.dekikkersprong.src.db.Database;
import com.example.vasq.dekikkersprong.src.db.PostgresqlDb;
import com.example.vasq.dekikkersprong.src.domain.Kind;
import com.example.vasq.dekikkersprong.src.domain.KindManager;
import com.example.vasq.dekikkersprong.src.domain.RekeningManager;
import com.example.vasq.dekikkersprong.src.domain.Verblijf;

public class Facade {

	private KindManager kindManager;
	private RekeningManager rekeningManager;
    private static Facade instance = null;
        private Database databank;

    private Facade() {
        databank = new PostgresqlDb();
        kindManager = new KindManager();

    }

    public String isConnected(){
        return databank.isConnected().toString();
    }
    public static Facade getInstance(){
        if (instance == null){
            instance = new Facade();
        }
        return instance;
    }

    public boolean klokIn(int kindId){
		return databank.klokIn(kindId);
	}

    public void addKind(String naam, String voornaam, int kindId){
         kindManager.addKind(naam,voornaam,kindId);
    }
	
	public boolean klokUit(int kindId){
		return databank.klokUit(kindId);
	}

    public HashMap<String, Verblijf> toonOverzicht(int kindId) {
        return databank.toonOverzicht(kindId);
    }

	//Returnt overzicht van verblijfuren
	public HashMap<Integer, Integer> verblijfOverzicht(int kindId){
		return rekeningManager.getOverzichtVoorKind(kindId);
	}
	//Returnt overzicht van bedragen
	public HashMap<String, Integer> rekeningOverzicht(int kindId){
		return rekeningManager.getVerblijfsOverzicht(kindId);
	}
	
}
