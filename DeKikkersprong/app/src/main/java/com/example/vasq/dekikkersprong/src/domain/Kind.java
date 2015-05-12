package com.example.vasq.dekikkersprong.src.domain;

public class Kind {
	private String naam, voornaam;
	private int id;
	private boolean isAanwezig;
	
	
	public Kind(String naam, String voornaam, int id) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) throws DomainException {
		if (naam == null){
			throw new DomainException("Naam kan niet null zijn");
		}
		this.naam = naam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam)throws DomainException {
		if (voornaam == null){
			throw new DomainException("Voornaam kan niet null zijn");
		}
		this.voornaam = voornaam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) throws DomainException {
		if (id < 0){
			throw new DomainException("Id kan niet kleiner dan nul zijn");
		}
		this.id = id;
	}
	public boolean isAanwezig() {
		return isAanwezig;
	}
	public void setAanwezig(boolean isAanwezig) {
		this.isAanwezig = isAanwezig;
	}
	
	
	
}
