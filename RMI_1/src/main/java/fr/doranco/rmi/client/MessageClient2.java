package fr.doranco.rmi.client;

import java.rmi.Naming;
import java.util.Scanner;

import fr.doranco.rmi.interfaces.RMIInterface;

public class MessageClient2 {
	
	private static RMIInterface look_up;


	public static void main(String[] args) {
		
		try {
			look_up = (RMIInterface) Naming.lookup("Message");
			
			Scanner scanner = new Scanner(System.in);
			String txt = "Vous voulez contacter le serveur. Veuiller entre votre nom ? : ";
			System.out.println(txt);
			String str = scanner.next();
			String reponse = look_up.helloTo(str);
			System.out.println("Le servuer à repondu : " +reponse);
			scanner.close();
		} catch (Exception e) {			
			System.err.println("Client exception: ");
			e.printStackTrace();
			System.exit(1);
		}
	}

}
