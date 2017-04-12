package main.java;

public class Menu{
	
	static final int MENU 0;
	static final int COMMANDES 1;
	static final int MANIPULATE 2;
	
	
	Menu(){
		
	}
	
	Public String dialog(String state){
		String sentence;
		switch(state){
			case MENU :
				sentence = "Menu :" + "1 : Commandes" + "2 : Manipulation";
				break;
			case COMMANDES :
				sentence = "";
				break;
			case MANIPULATE :
				sentence = "Entrée incorrecte";
				break;
			default :
				sentence = "Entrée incorrecte";

		}
		return sentence;
	}
}