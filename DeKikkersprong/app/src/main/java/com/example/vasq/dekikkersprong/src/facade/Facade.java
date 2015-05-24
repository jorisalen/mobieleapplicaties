package com.example.vasq.dekikkersprong.src.facade;

import java.util.Date;
import java.util.HashMap;

import com.example.vasq.dekikkersprong.src.db.Database;
import com.example.vasq.dekikkersprong.src.db.GeheugenDatabase;
import com.example.vasq.dekikkersprong.src.db.PostgresqlDb;
import com.example.vasq.dekikkersprong.src.domain.Kind;
import com.example.vasq.dekikkersprong.src.domain.KindManager;
import com.example.vasq.dekikkersprong.src.domain.RekeningManager;

public class Facade {

	private KindManager kindManager;
	private RekeningManager rekeningManager;
    private static Facade instance = null;
        private Database databank;

    private Facade() {
        databank = new PostgresqlDb();
        kindManager = new KindManager();
    }

    public boolean isConnected(){
        return databank.isConnected();
    }
    public static Facade getInstance(){
        if (instance == null){
            instance = new Facade();
        }
        return instance;
    }

    public boolean klokIn(int kindId){
		return kindManager.klokIn(kindId);
	}

    public void addKind(String naam, String voornaam, int kindId){
         kindManager.addKind(naam,voornaam,kindId);
    }
	
	public String klokUit(int kindId){
		return kindManager.klokUit(kindId);
	}

    public HashMap<String, String> toonOverzicht() {
        return databank.toonOverzicht();
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
