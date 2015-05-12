package com.example.vasq.dekikkersprong.src.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Rekening {
	private double totaalBedrag, betaaldBedrag;
	private boolean betaald;
	private int id,kindId;
	private ArrayList<Verblijf> verblijven;
	
	
	
	public Rekening(int id, int kindId) {
		this.id = id;
		this.kindId = kindId;
		this.verblijven = new ArrayList<Verblijf>();
	}
	public double getTotaalBedrag() {
		return totaalBedrag;
	}
	public void setTotaalBedrag(double totaalBedrag) throws DomainException {
		if(totaalBedrag < 0){
			throw new DomainException("totaalbedrag");
		}
		this.totaalBedrag = totaalBedrag;
	}
	public double getBetaaldBedrag() {
		return betaaldBedrag;
	}
	public void setBetaaldBedrag(double betaaldBedrag) throws DomainException {
		if (betaaldBedrag < 0){
			throw new DomainException("Betaaldbedrag kan niet negatief zijn");
		}
		this.betaaldBedrag = betaaldBedrag;
	}
	public boolean isBetaald() {
		return betaald;
	}
	public void setBetaald(boolean betaald) {
		this.betaald = betaald;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	
	public void addVerblijf(String info, Date datum, int tijd, int rekeningId){
		Verblijf verblijf = new Verblijf(info, datum, tijd, rekeningId);
			
		verblijven.add(verblijf);
		
		
	}
	
	public  HashMap<Integer, Integer> getOverzicht(){
		return null;
		
	}
	
}
