package com.example.vasq.dekikkersprong.src.domain;

import java.util.Date;

public class Verblijf {
	
	private String info;
	private Date datum;
	private int tijd;
	private int rekeningId;
	
	public Verblijf(String info, Date datum, int tijd, int rekeningId) {
		this.info = info;
		this.datum = datum;
		this.tijd = tijd;
		this.rekeningId = rekeningId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getTijd() {
		return tijd;
	}
	public void setTijd(int tijd) {
		this.tijd = tijd;
	}
	public int getRekeningId() {
		return rekeningId;
	}
	public void setRekeningId(int rekeningId) {
		this.rekeningId = rekeningId;
	}
}
