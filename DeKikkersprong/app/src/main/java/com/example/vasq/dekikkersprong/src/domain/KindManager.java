package com.example.vasq.dekikkersprong.src.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KindManager {
	private HashMap<Integer, Kind> kinderen;
	
	
	public KindManager() {

        this.kinderen = new HashMap<Integer,Kind>();
        kinderen.put(1, new Kind("Deboutte", "Bob", 1));
	}

	public String klokIn(int kindId){
		if (!kinderen.get(kindId).isAanwezig()){
			kinderen.get(kindId).setAanwezig(true);
            return "Welkom, " + kinderen.get(kindId).getVoornaam() +"!";
		}else{
            return "Kind is al aanwezig !";
        }

	}
	
	public String klokUit(int kindId){
		if (kinderen.get(kindId).isAanwezig()){
			kinderen.get(kindId).setAanwezig(false);
		}
		return "Fijne avond, " + kinderen.get(kindId).getVoornaam() + "!";
		
	}

    public void addKind(String naam, String voornaam, int kindId){
        kinderen.put(kindId, new Kind(naam, voornaam, kindId));
    }

	public Kind getKind(int kindId){
		try{
            return kinderen.get(kindId);
        }finally{
            return null;
        }

	}
	
	public HashMap<Integer,Kind> aanwezigheden(){
        return kinderen;
	}
}
