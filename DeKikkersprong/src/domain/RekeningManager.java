package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class RekeningManager {
	private ArrayList<Rekening> rekeningen;

	public RekeningManager() {
		this.rekeningen = new ArrayList<Rekening>();
	}
	
	public HashMap<Integer, Integer> getOverzicht(){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Rekening e : rekeningen){
			map.put(e.getKindId(), e.getKindId());
		}
		
		return map;
	}
	
	public  HashMap<String, Integer>  getVerblijfsOverzicht(int kindId){
		return null;
	}
	
	public HashMap<String, Integer> getOverzichtVoorKind(int kindId){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		return map;
	}
	
	
	
	
}
