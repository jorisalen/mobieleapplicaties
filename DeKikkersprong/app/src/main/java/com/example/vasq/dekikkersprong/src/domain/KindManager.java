package com.example.vasq.dekikkersprong.src.domain;

import java.util.ArrayList;
import java.util.Date;

public class KindManager {
	private ArrayList<Kind> kinderen;
	
	
	
	public KindManager() {
		this.kinderen = new ArrayList<Kind>();
	}

	public String klokIn(int kindId, Date datum){
		if (!kinderen.get(kindId).isAanwezig()){
			kinderen.get(kindId).setAanwezig(true);
		}
		return "Welkom, " + kinderen.get(kindId).getVoornaam() + "!";
	}
	
	public String klokUit(int kindId, Date datum){
		if (kinderen.get(kindId).isAanwezig()){
			kinderen.get(kindId).setAanwezig(false);
		}
		return "Fijne avond, " + kinderen.get(kindId).getVoornaam() + "!";
		
	}
	
	public Kind getKind(int kindId){
		for (Kind e : kinderen){
			if(e.getId()== kindId){
				return e;
			}
		}
		return null;
	}
	
	public ArrayList<Kind> aanwezigheden(){
		ArrayList<Kind> aanwezig = new ArrayList<Kind>();
		for (Kind e : kinderen){
			if(e.isAanwezig()){
				aanwezig.add(e);
			}
		}
		return aanwezig;
	}
	
	public ArrayList<Kind> afwezigheden(){
		ArrayList<Kind> afwezig = new ArrayList<Kind>();
		for (Kind e : kinderen){
			if(!e.isAanwezig()){
				afwezig.add(e);
			}
		}
		return afwezig;
	}
}
