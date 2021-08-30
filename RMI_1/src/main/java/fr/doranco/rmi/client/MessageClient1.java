package fr.doranco.rmi.client;

import java.rmi.Naming;

import fr.doranco.rmi.interfaces.RMIInterface;

public class MessageClient1 {
	
	private static RMIInterface look_up;
	
	public static void main(String[] args) {
		
		try {
			look_up = (RMIInterface) Naming.lookup("Message");
			
			String message = "Bonjour serveur !";
			System.out.println("Le message à envoyer au serveur : " +message);
			
			String reponse = look_up.helloTo(null);
			System.out.println("Le servuer à repondu : " +reponse);
		} catch (Exception e) {
			
			System.err.println("Client exception: ");
			e.printStackTrace();
			System.exit(1);
		}
	}

}
