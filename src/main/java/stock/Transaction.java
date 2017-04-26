package java.stock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Transaction{
	private Commandes cmd;
	
	public Transaction(){
		cmd = new Commandes();
	}
	
	public void printCommande(){
		System.out.println(
				"GET key\n"+ 
				"SET key value\n"+
				"DECR key\n"+ 
				"INCR  key\n"+
				"DEL  key\n"+		
				"LPUSH key list value\n"+ 
				"RPUSH key list value \n"+
				"LPOP  key\n"+ 
				"RPOP  key\n"+ 
				"LLEN  key\n"+ 		
				"SREM  key value\n" + 
				"SADD  key value\n"+
				"SISMEMBER  key value\n" + 
				"SMEMBERS  key\n"+
				"SUNION  key1 key2\n"+	 
				"HSET  key field value\n"+
				"HGETALL  key\n"+
				"HGET  key field\n"+
				"HINCRBY  key field value\n"+
				"HDECRBY  key field value \n"+
				"HDEL  key field\n"
				);
	}
	
	public int execCommande(String s){
		String[] input = s.split(" ");
		if(input[0] != null){
			switch (input[0].toUpperCase()) {
			
				case "GET" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print = cmd.GET(input[1]);						
						System.out.println(print);		
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}
						
					}
				
				case "SET" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						String print = cmd.SET(input[1],input[2]) ;						
						System.out.println(print);
						if(print.equals("OK")){
							return 0;
						}else{
							return -1;
						}
					}						
					
				case "DECR" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.DECR(input[1]);						
						System.out.println(print);
						String[] splitPrint = print.split(" ");
						if(splitPrint[0].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}
					}
					
					
				case "INCR" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.INCR(input[1]);						
						System.out.println(print);
						String[] splitPrint = print.split(" ");
						if(splitPrint[0].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}
					}
					
					
				case "DEL" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.DEL(input[1]);						
						System.out.println(print);
						String[] splitPrint = print.split(" ");
						if(splitPrint[0].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}
					}
					
					
				case "LPUSH" :
					if(input.length < 3){
						return execCommande("ERROR");
					}else{
						LinkedList<String> list1 = new LinkedList<String>();
						for(int i = 2; i < input.length; i++){
							list1.add(input[i]);
						}
						System.out.println(cmd.LPUSH(input[1],list1));
						return 0;
					}
				
				case "RPUSH" :
					if(input.length < 3){
						return execCommande("ERROR");
					}else{
						LinkedList<String> list2 = new LinkedList<String>();
						for(int i = 2; i < input.length; i++){
							list2.add(input[i]);
						}
						System.out.println(cmd.RPUSH(input[1],list2));					
						return 0;
					}
					
				case "LPOP" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.LPOP(input[1]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}
					}
				
				
				case "RPOP" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.RPOP(input[1]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}						
					}
					
					
				case "LLEN" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.LLEN(input[1]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}
						
					}
					
					
				case "SREM" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.SREM(input[1],input[2]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}					
					}
					
					
				case "SADD" :
					if(input.length < 3){
						return execCommande("ERROR");
					}else{
						Set<String> set = new HashSet<String>();
						for(int i = 2; i < input.length; i++){
							set.add(input[i]);
						}
						System.out.println(cmd.SADD(input[1],set));
						return 0;
					}
					
				case "SISMEMBER" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.SISMEMBER(input[1],input[2]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}	
						
					}
					
					
				case "SMEMBERS" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.SMEMBERS(input[1]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}
						
					}
					
					
				case "SUNION" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						System.out.println(cmd.SUNION(input[1],input[2]));
						return 0;
					}
					
					
				case "HSET" :
					if(input.length != 4){						
						return execCommande("ERROR");
					}else{
						System.out.println(cmd.HSET(input[1],input[2],input[3]));
						return 0;
					}
					
					
				case "HGETALL" :
					if(input.length != 2){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.HGETALL(input[1]);						
						System.out.println(print);
						if(print.equals("the given key does not exists")){
							return -1;
						}else{
							return 0;
						}
						
					}
					
					
				case "HGET" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.HGET(input[1],input[2]);						
						System.out.println(print);
						if((print.equals("the given key does not exists"))||(print.equals("the given field does not exist"))){
							return -1;
						}else{
							return 0;
						}
						
					}
					
					
				case "HINCRBY" :
					if(input.length != 4){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.HINCRBY(input[1],input[2],input[3]);						
						System.out.println(print);
						String[] splitPrint = print.split(" "); 
						if(splitPrint[1].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}	
						
					}
					
				
				case "HDECRBY" :
					if(input.length != 4){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.HDECRBY(input[1],input[2],input[3]);						
						System.out.println(print);
						String[] splitPrint = print.split(" "); 
						if(splitPrint[1].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}												
					}
					
				case "HDEL" :
					if(input.length != 3){						
						return execCommande("ERROR");
					}else{
						String print =  cmd.HDEL(input[1],input[2]);						
						System.out.println(print);
						String[] splitPrint = print.split(" "); 
						if(splitPrint[1].equals("(Integer)")){
							return 0;
						}else{
							return -1;
						}							
					}					
					
				case "ERROR" : 
					System.out.println("number of arguements in the command does not match");
					return -1;
				default :
					System.out.println("the command does not exist");
					return -1;
			}
				
				
		}else{
			return -1;
		}
		
	}
	
	public void undoCommand(String s){
		String[] input = s.split(" ");
		if(input[0] != null){
			switch (input[0].toUpperCase()) {
			
				case "GET" :					
					break;
					
				case "SET" :
					cmd.removeString(input[1]);					
					break;
					
				case "DECR" :
					cmd.removeString(input[1]);
					break;
					
				case "INCR" :
					cmd.removeString(input[1]);
					break;
					
				case "DEL" :
					cmd.removeString(input[1]);
					break;
					
				case "LPUSH" :
					cmd.removeList(input[1]);
					break;
				
				case "RPUSH" :
					cmd.removeList(input[1]);					
					break;
				
				case "LPOP" :					
					break;
				
				case "RPOP" :				
					break;
					
				case "LLEN" :					
					break;
					
				case "SREM" :					
					break;
					
				case "SADD" :
					cmd.removeSet(input[1]);
					break;
					
				case "SISMEMBER" :					
					break;
					
				case "SMEMBERS" :					
					break;
					
				case "SUNION" :
					cmd.removeList(input[1]);							
					break;
					
				case "HSET" :
					cmd.removeHash(input[1]);
					break;
					
				case "HGETALL" :					
					break;
					
				case "HGET" :					
					break;
					
				case "HINCRBY" :
					cmd.removeHash(input[1]);
					break;
				case "HDECRBY" :
					cmd.removeHash(input[1]);
					break;
				case "HDEL" :
					cmd.removeHash(input[1]);
					break;				
				
				default :					
			}
				
				
		}
	}
	
	public int size(){
		return cmd.size();
	}
		
}