package stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;

public class Menu{
	
	static int MEMORYOVERFLOW = 15;
	private ArrayList<String> historique;
	private Transaction tr ;

	
	Menu(){
		historique = new ArrayList<String>();
		tr = new Transaction();		
	}
	
	public void printHist(){
		for(String s : historique){
			System.out.println(s);
		}
		System.out.println(tr.size());
	}
	
	public void updateMemory(){
		while(tr.size() > MEMORYOVERFLOW){
			String tmp = historique.remove(0);
			tr.undoCommand(tmp);
		}
	}
	
	public int dialog(String input){
		updateMemory();
		if(input.equals("-help")){
			tr.printCommande();			
			return 0;
		}else if(input.equals("-quit")){		
			return -1;
		}else if(input.equals("-hist")){
			printHist();
			return 0;
		}else{
			int res = tr.execCommande(input);
			if(res == 0){
				historique.add(input);
			}
			return 0;
		}

	}
	
	public static void main(String args[]) throws IOException{
		Menu m = new Menu();
		System.out.println("to see the list of commands tape -help, -hist to print the historic of commands -quit pour quitter");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = br.readLine();
		while(m.dialog(inputLine) != -1){
			inputLine = br.readLine();
		}
		
	}
}