package fr.doranco.rmi.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import fr.doranco.rmi.client.OperationsClient;

import javax.swing.JLabel;

public class ClientFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField valeurA;
	private JTextField valeurB;
	private JPanel panel;
	private JComboBox<String> operateur;
	private JButton boutonCalculer;
	private JButton boutonInitialiser;
	private JButton boutonFermer;
	private JLabel label;
	private JTextField resultat;

	/**
	 * Create the application.
	 */
	public ClientFenetre() {
		initializeFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() {
		
		setSize(700, 300);
		setBounds(100, 100, 642, 310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Appel d'objets distants avec Java RMI");
		setLocationRelativeTo(null); // positionnner la fenêtre au centre de l'écran
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setResizable(false);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		valeurA = new JTextField();
		valeurA.setFont(new Font("Arial", Font.PLAIN, 22));
		valeurA.setForeground(Color.BLACK);
		valeurA.setBounds(42, 34, 128, 33);
		valeurA.setColumns(10);
		panel.add(valeurA);
		valeurA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				verifierValeurSaisie(e);
			}
		});
		
		valeurB = new JTextField();
		valeurB.setForeground(Color.BLACK);
		valeurB.setFont(new Font("Arial", Font.PLAIN, 22));
		valeurB.setColumns(10);
		valeurB.setBounds(272, 34, 128, 33);
		panel.add(valeurB);
		valeurB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				verifierValeurSaisie(e);
			}
		});
		
		operateur = new JComboBox<String>();
		operateur.setFont(new Font("Arial", Font.BOLD, 22));
		operateur.setModel(new DefaultComboBoxModel<String>(new String[] {"", "+", "-", "*", "/"}));
//		operateur.addItem("");
//		operateur.addItem("+");
//		operateur.addItem("-");
//		operateur.addItem("*");
//		operateur.addItem("/");
		operateur.setBounds(189, 34, 55, 30);
		panel.add(operateur);
		
		boutonCalculer = new JButton("Calculer");
		boutonCalculer.setFont(new Font("Arial", Font.PLAIN, 20));
		boutonCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculer();
			}
		});
		
		boutonCalculer.setBounds(44, 96, 142, 26);
		panel.add(boutonCalculer);
		
		boutonInitialiser = new JButton("Initialiser");
		boutonInitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialiser();
			}
		});
		
		boutonInitialiser.setFont(new Font("Arial", Font.PLAIN, 20));
		boutonInitialiser.setBounds(440, 41, 142, 26);
		panel.add(boutonInitialiser);
		
		boutonFermer = new JButton("Fermer");
		boutonFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});
		boutonFermer.setFont(new Font("Arial", Font.PLAIN, 20));
		boutonFermer.setBounds(440, 233, 142, 26);
		panel.add(boutonFermer);
		
		label = new JLabel("affichage");
		label.setBounds(26, 196, 56, 16);
		panel.add(label);
		
		resultat = new JTextField();
		resultat.setForeground(Color.BLUE);
		resultat.setFont(new Font("Arial", Font.PLAIN, 22));
		resultat.setColumns(10);
		resultat.setBounds(216, 92, 260, 33);
		panel.add(resultat);

	}
	
	private void verifierValeurSaisie(KeyEvent e) {
		char c = e.getKeyChar();
	}
	
	private void calculer() {
		
		if (valeurA.getText().toString().equals("") || valeurB.getText().toString().equals("") || operateur.getSelectedIndex() == 0 ) {
			
			label.setForeground(Color.RED);
			label.setText("Il faut selectionner les 2 valeur et l'operateur");
			return;
		}
		//... vérifier si les deux valeurs ainsi que l'opérateur ont bien été sélectionnés
		//...sinon no affiche un message d'erreur sur le label en rouge

		OperationsClient operations = null;
		try {
			operations = new OperationsClient();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			label.setText("Erreur de connexion au serveur !");
			System.out.println(e);
		}
		try {
			
			int a = Integer.parseInt(valeurA.getText().toString());
			int b = Integer.parseInt(valeurB.getText().toString());
	
			switch (operateur.getSelectedItem().toString()) {
			
				case "+":
					operations.add(a, b);
					break;
		
				case "-":
					operations.substract(a, b);
					break;
		
				case "*":
					operations.multiply(a, b);
					break;
		
				case "/":
					operations.divide(a, b);
					break;
		
				default:
					break;
			}
			
		} catch (RemoteException e) {
			label.setText("Erreur du serveur lors de l'exécution de l'opération !");
			System.out.println(e);
		}
		
	}
	
	private void initialiser() {
		
		label.setText("");
		valeurA.setText("");
		valeurB.setText("");
		operateur.setSelectedItem("");
		resultat.setText("");
	}
	
	private void fermer() {
		dispose();
	}
}
