import java.util.HashMap;

public class Bibliotheque {
	HashMap<String, String> stock;
	
	public Bibliotheque(){
		stock = new HashMap<String,String>();
	}
	
	public void set(String key, String value){		
		stock.put(key, value);
	}
	
	public String get(String key){
		return stock.get(key);
	}
	
}
