package fr.doranco.rmi.client;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import fr.doranco.rmi.interfaces.RMIInterface;

public class MessageClient3 {
	
	private static RMIInterface look_up;
	
	public static void main(String[] args) {
		
		try {
			look_up = (RMIInterface) Naming.lookup("Message");
			String txt = JOptionPane.showInputDialog("Vous voulez contacter le serveur. Veuiller entre votre nom ? : ");
			String reponse = look_up.helloTo(txt);
			JOptionPane.showInputDialog(null,"Le serveur à repondu" +reponse);
		} catch (Exception e) {			
			System.err.println("Client exception: ");
			e.printStackTrace();
			System.exit(1);
		}
	
	}

}
