package com.example.vasq.dekikkersprong.src.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class RekeningManager {
	private ArrayList<Rekening> rekeningen;

	public RekeningManager() {
		this.rekeningen = new ArrayList<Rekening>();
	}

    public Rekening getBoeking(int kindId){
        return rekeningen.get(kindId);
    }

	public ArrayList<Rekening> getBoekingen(){

		return rekeningen;
	}
	
	
	
	
}
