package com.example.vasq.dekikkersprong.src.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Verblijf {
	
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

	public int getRekeningId() {
		return rekeningId;
	}
	public void setRekeningId(int rekeningId) {
		this.rekeningId = rekeningId;
	}
}
