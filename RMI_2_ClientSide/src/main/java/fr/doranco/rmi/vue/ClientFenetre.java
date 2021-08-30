package fr.doranco.rmi.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

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

	public ClientFenetre() {
		initializeFrame();
	}

	private void initializeFrame() {
		
		setSize(700, 300);
		setBounds(100, 100, 642, 310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Appel d'objets distants avec Java RMI");
		setLocationRelativeTo(null); // positionnner la fenêtre au centre de l'écran
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setResizable(false);
		
		buildContent();

	}
	
	private void buildContent() {
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		valeurA = new JTextField();
		valeurA.setFont(new Font("Arial", Font.PLAIN, 22));
		valeurA.setForeground(Color.BLACK);
		valeurA.setBounds(42, 34, 137, 33);
		valeurA.setColumns(10);
		panel.add(valeurA);
		valeurA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				verifierValeurSaisie(e, valeurA);
			}
		});
		
		valeurB = new JTextField();
		valeurB.setForeground(Color.BLACK);
		valeurB.setFont(new Font("Arial", Font.PLAIN, 22));
		valeurB.setColumns(10);
		valeurB.setBounds(272, 34, 137, 33);
		panel.add(valeurB);
		valeurB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				verifierValeurSaisie(e, valeurB);
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
		operateur.setBounds(189, 35, 55, 30);
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
		
		label = new JLabel("");
		label.setBounds(26, 196, 467, 16);
		panel.add(label);
		
		resultat = new JTextField();
		resultat.setForeground(Color.BLUE);
		resultat.setFont(new Font("Arial", Font.PLAIN, 22));
		resultat.setColumns(10);
		resultat.setBounds(216, 92, 260, 33);
		panel.add(resultat);
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
	
	private void verifierValeurSaisie(KeyEvent evt,JTextField textField) {

        char c = evt.getKeyChar();
//        Action cut = new DefaultEditorKit.CutAction();
//        cut.putValue(Action.NAME, "Cut");
//        cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        //|| KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK)
        //  KeyStroke.getKeyStroke("control X")
        if ( textField.getText().length() >= 9
                || (!Character.isDigit(c) && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_BACK_SPACE
                		)){

            evt.consume(); // ignorer l'événement : consomme le caractère saisi, c'est à dire ne l'affiche pas
            getToolkit().beep();
        } 
    }
	
	private void calculer() {
		
		if (valeurA.getText().toString().equals("") || valeurB.getText().toString().equals("") || operateur.getSelectedIndex() == 0 ) {
			
			label.setForeground(Color.RED);
			label.setText("Il faut selectionner les 2 valeurs et l'operateur");
			return;
		}

		
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
			Long Oper; 
			Integer opDiv;
			switch (operateur.getSelectedItem().toString()) {
			
				case "+":
					Oper = operations.add(a, b);					
					resultat.setText(Oper.toString());
					break;
		
				case "-":
					
					Oper = operations.substract(a, b);
					resultat.setText(Oper.toString());
					break;
		
				case "*":
					Oper = operations.multiply(a, b);
					resultat.setText(Oper.toString());
					break;
		
				case "/":
					if (b==0) {
						label.setForeground(Color.RED);
						label.setText("La Division par 0 est impossible");
						return;
					}
					opDiv =  operations.divide(a, b);
					resultat.setText(opDiv.toString());
					
					break;
		
				default:
					break;
			}
			label.setForeground(Color.GREEN);
			label.setText("Operation reussie");
		} catch (RemoteException e) {
			label.setText("Erreur du serveur lors de l'exécution de l'opération !");			
			System.out.println(e);
		}
		
	}
	
}
