package stock;

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
	
	public void execCommande(String s){
		String[] input = s.split(" ");
		if(input[0] != null){
			switch (input[0].toUpperCase()) {
			
				case "GET" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.GET(input[1]));
					}
					break;
					
				case "SET" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.SET(input[1],input[2]));
					}					
					break;
					
				case "DECR" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.DECR(input[1]));
					}
					break;
					
				case "INCR" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.INCR(input[1]));
					}
					break;
					
				case "DEL" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.DEL(input[1]));
					}
					break;
					
				case "LPUSH" :
					LinkedList<String> list1 = new LinkedList<String>();
					for(int i = 2; i < input.length; i++){
						list1.add(input[i]);
					}
					System.out.println(cmd.LPUSH(input[1],list1));
					break;
				
				case "RPUSH" :
					LinkedList<String> list2 = new LinkedList<String>();
					for(int i = 2; i < input.length; i++){
						list2.add(input[i]);
					}
					System.out.println(cmd.RPUSH(input[1],list2));					
					break;
				
				case "LPOP" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.LPOP(input[1]));
					}
					break;
				
				case "RPOP" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.RPOP(input[1]));
					}
					break;
					
				case "LLEN" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.LLEN(input[1]));
					}
					break;
					
				case "SREM" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.SREM(input[1],input[2]));
					}
					break;
					
				case "SADD" :
					Set<String> set = new HashSet<String>();
					for(int i = 2; i < input.length; i++){
						set.add(input[i]);
					}
					System.out.println(cmd.SADD(input[1],set));
					break;
					
				case "SISMEMBER" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.SISMEMBER(input[1],input[2]));
					}
					break;
					
				case "SMEMBERS" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.SMEMBERS(input[1]));
					}
					break;
					
				case "SUNION" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.SUNION(input[1],input[2]));
					}
					break;
					
				case "HSET" :
					if(input.length != 4){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HSET(input[1],input[2],input[3]));
					}
					break;
					
				case "HGETALL" :
					if(input.length != 2){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HGETALL(input[1]));
					}
					break;
					
				case "HGET" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HGET(input[1],input[2]));
					}
					break;
					
				case "HINCRBY" :
					if(input.length != 4){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HINCRBY(input[1],input[2],input[3]));
					}
					break;
				case "HDECRBY" :
					if(input.length != 4){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HDECRBY(input[1],input[2],input[3]));
					}
					break;
				case "HDEL" :
					if(input.length != 3){						
						execCommande("ERROR");
					}else{
						System.out.println(cmd.HDEL(input[1],input[2]));
					}
					break;
				case "ERROR" : 
					System.out.println("number of arguements in the command does not match");
					break;
				default :
					System.out.println("the command does not exist");
			}
				
				
		}
		
	}
		
}

