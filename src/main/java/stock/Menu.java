package stock;

import java.lang.String;

public class Menu{
	
	static final int MENU = 0;
	static final int COMMANDES = 1;
	static final int MANIPULATE = 2;
	
	private Transaction tr ;
	private int state;
	
	Menu(){
		state = 0;
		tr = new Transaction();
	}
	
	public void dialog(String input){

		switch(state){
			case MENU :
				System.out.println("Menu :" + "1 : Commands" + "2 : Manipulation");
				if(input.equals("1")){
					tr.printCommande();;
				}else if(input.equals("2")){
					state = MANIPULATE;
				}else{
					System.out.println("");
				}
				
				break;
				
			case COMMANDES :
				
				break;
			case MANIPULATE :
				tr.execCommande(input);
				break;
			default :
				System.out.println("Entrée incorrecte");

		}
	}
	
}