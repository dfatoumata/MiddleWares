package fr.doranco.rmi.vue;

import java.awt.EventQueue;

public class ApplicationClient {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFenetre fenetre = new ClientFenetre(); // cette classe doit hériter de JFrame
					fenetre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
