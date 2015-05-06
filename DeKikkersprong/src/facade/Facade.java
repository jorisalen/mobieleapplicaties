package facade;

import java.util.Date;
import java.util.HashMap;

import domain.Kind;
import domain.KindManager;
import domain.RekeningManager;

public class Facade {

	private KindManager kindManager;
	private RekeningManager rekeningManager;
	
	
	public String kloklIn(int kindId, Date date){
		return kindManager.klokIn(kindId, date);
	}
	
	public String kloklUit(int kindId, Date date){
		return kindManager.klokUit(kindId, date);
	}
	
	
	//Returnt overzicht van verblijfuren
	public HashMap<String, Integer> verblijfOverzicht(int kindId){
		return rekeningManager.getOverzichtVoorKind(kindId);
	}
	//Returnt overzicht van bedragen
	public HashMap<String, Integer> rekeningOverzicht(int kindId){
		return rekeningManager.getVerblijfsOverzicht(kindId);
	}
	
}
