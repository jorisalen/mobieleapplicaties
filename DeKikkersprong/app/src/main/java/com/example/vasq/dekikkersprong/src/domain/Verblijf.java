package com.example.vasq.dekikkersprong.src.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Verblijf implements Serializable{

    private static final long serialVersionUID = 37827389217389L;

	private int kindId;
    private int id;
    Timestamp tijdIn,tijdUit;
	private int rekeningId;



    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public Timestamp getTijdUit() {
        return tijdUit;
    }

    public void setTijdUit(Timestamp tijdUit) {
        this.tijdUit = tijdUit;
    }

    public Timestamp getTijdIn() {
        return tijdIn;
    }

    public void setTijdIn(Timestamp tijdIn) {
        this.tijdIn = tijdIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Verblijf(int kindId, Timestamp tijdIn, Timestamp tijdUit) {
        this.tijdIn = tijdIn;
        this.tijdUit = tijdUit;
        this.kindId = kindId;
	}

    public long getTijd()
    {
        long milliseconds1 = tijdUit.getTime();
        long milliseconds2 = tijdIn.getTime();

        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffHours;
    }

    public int getMaand(){
        long timestamp = tijdUit.getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp);
        return cal.get(Calendar.MONTH);
    }

	public int getRekeningId() {
		return rekeningId;
	}
	public void setRekeningId(int rekeningId) {
		this.rekeningId = rekeningId;
	}

    public String toString(){
        return "Uren aanwezig:" +  getTijd() ;
    }
}
