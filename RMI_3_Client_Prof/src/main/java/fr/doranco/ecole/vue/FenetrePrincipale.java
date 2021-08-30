package fr.doranco.ecole.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JRadioButton radioButtonEtudiant;
	private JRadioButton radioButtonEnseignant;
	private JLabel labelOption;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldOption; // Spécialité/Poste
	private JTextField textFieldNumero;
	private JTextField textFieldRue;
	private JTextField textFieldVille;
	private JTextField textFieldCodePostal;
	private JTextArea textArea;

	public FenetrePrincipale () {
		initialize();
		buildContentPane();
	}
	
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	}
	
	private void buildContentPane() {

		JLabel labelCategorie = new JLabel("Catégorie :");
		labelCategorie.setBounds(24, 18, 66, 16);
		contentPane.add(labelCategorie);

		radioButtonEtudiant = new JRadioButton("Etudiant");
		radioButtonEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelOption.setText("Spécialité :");
			}
		});
		radioButtonEtudiant.setBounds(98, 14, 83, 25);
		radioButtonEtudiant.setText("Etudiant");
		radioButtonEtudiant.setSelected(true);
		contentPane.add(radioButtonEtudiant);

		radioButtonEnseignant = new JRadioButton("Enseignant");
		radioButtonEnseignant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelOption.setText("Poste :");
			}
		});
		radioButtonEnseignant.setBounds(185, 14, 97, 25);
		radioButtonEnseignant.setText("Enseignant");
		contentPane.add(radioButtonEnseignant);

		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(radioButtonEtudiant);
		radioButtonGroup.add(radioButtonEnseignant);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(24, 76, 119, 22);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(155, 76, 116, 22);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldOption = new JTextField();
		textFieldOption.setBounds(283, 76, 108, 22);
		contentPane.add(textFieldOption);
		textFieldOption.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(24, 132, 44, 22);
		contentPane.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldRue = new JTextField();
		textFieldRue.setBounds(88, 132, 194, 22);
		contentPane.add(textFieldRue);
		textFieldRue.setColumns(10);
		
		textFieldVille = new JTextField();
		textFieldVille.setBounds(305, 132, 108, 22);
		contentPane.add(textFieldVille);
		textFieldVille.setColumns(10);
		
		textFieldCodePostal = new JTextField();
		textFieldCodePostal.setBounds(433, 132, 68, 22);
		contentPane.add(textFieldCodePostal);
		textFieldCodePostal.setColumns(10);
		
		JButton btnAjouter = new JButton(new AjouterAction(this));
		btnAjouter.setText("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAjouter.setBounds(136, 167, 97, 25);
		contentPane.add(btnAjouter);

		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(24, 58, 66, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom :");
		lblNewLabel_1.setBounds(155, 58, 90, 16);
		contentPane.add(lblNewLabel_1);
		
		labelOption = new JLabel("Spécialité :");
		labelOption.setBounds(283, 58, 118, 16);
		contentPane.add(labelOption);
		
		JLabel lblNewLabel_3 = new JLabel("N° :");
		lblNewLabel_3.setBounds(24, 111, 66, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rue/Avenue/Bd/Impasse :");
		lblNewLabel_4.setBounds(88, 111, 163, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ville :");
		lblNewLabel_5.setBounds(305, 111, 86, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CP :");
		lblNewLabel_6.setBounds(433, 111, 56, 16);
		contentPane.add(lblNewLabel_6);
		
//		JList list = new JList();
//		list.setBounds(120, 266, 1, 1);
//		contentPane.add(list);
		
		Object[] items = new Object[] {"Aucun", "Spécialité", "Groupe", "Section"};
		JComboBox<String> comboBox = new JComboBox(items);
		comboBox.setBounds(24, 249, 119, 22);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		JButton buttonAfficher_1 = new JButton("Afficher");
		buttonAfficher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonAfficher_1.setBounds(154, 248, 97, 25);
		contentPane.add(buttonAfficher_1);
		
		JLabel lblNewLabel_7 = new JLabel("Liste Etudiants par :");
		lblNewLabel_7.setBounds(24, 226, 292, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Liste Enseignants :");
		lblNewLabel_8.setBounds(24, 308, 178, 16);
		contentPane.add(lblNewLabel_8);
		
		Object[] items2 = new Object[] {"Aucun", "Maitre de conf.", "Ingénieur", "Docteur", "Professeur"};
		JComboBox comboBox_1 = new JComboBox(items2);
		comboBox_1.setBounds(24, 329, 119, 22);
		contentPane.add(comboBox_1);
		
		JButton buttonAfficher_2 = new JButton("Afficher");
		buttonAfficher_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		buttonAfficher_2.setBounds(154, 328, 97, 25);
		contentPane.add(buttonAfficher_2);
		
		JLabel lblNewLabel_9 = new JLabel("Liste des Etudiants d'un Enseignant :");
		lblNewLabel_9.setBounds(24, 379, 227, 16);
		contentPane.add(lblNewLabel_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(24, 400, 119, 22);
		comboBox_2.addItem("Aucun");
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_10 = new JLabel("Liste des Enseignants d'un \u00E9tudiant :");
		lblNewLabel_10.setBounds(24, 451, 221, 16);
		contentPane.add(lblNewLabel_10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.addItem("Aucun");
		comboBox_3.setBounds(24, 472, 119, 22);
		contentPane.add(comboBox_3);
		
		textArea = new JTextArea();
		textArea.setBounds(283, 249, 208, 245);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setForeground(Color.blue);
		//contentPane.add(textArea);
		
		JScrollPane pane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setBounds(283, 249, 208, 245);
		contentPane.add(pane);
		
		JButton buttonAfficher_3 = new JButton("Afficher");
		buttonAfficher_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonAfficher_3.setBounds(154, 399, 97, 25);
		contentPane.add(buttonAfficher_3);
		
		JButton buttonAfficher_4 = new JButton("Afficher");
		buttonAfficher_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonAfficher_4.setBounds(155, 471, 97, 25);
		contentPane.add(buttonAfficher_4);
		
		JLabel lblNewLabel_11 = new JLabel("Résultat :");
		lblNewLabel_11.setBounds(283, 226, 56, 16);
		contentPane.add(lblNewLabel_11);
		
		JButton buttonInitialiser = new JButton("Initialiser");
		buttonInitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonGroup.clearSelection();
				radioButtonEtudiant.setSelected(true);
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				labelOption.setText("Spécialité");
				textFieldOption.setText("");
				textFieldNumero.setText("");
				textFieldRue.setText("");
				textFieldVille.setText("");
				textFieldCodePostal.setText("");
				textArea.setText("");
				textArea.setForeground(Color.blue);
			}
		});
		buttonInitialiser.setBounds(24, 167, 97, 25);
		contentPane.add(buttonInitialiser);

//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setBounds(491, 249, 21, 245);
//		contentPane.add(scrollBar);
	}

	public JRadioButton getRadioButtonEtudiant() {
		return radioButtonEtudiant;
	}

	public JRadioButton getRadioButtonEnseignant() {
		return radioButtonEnseignant;
	}

	public JLabel getLabelOption() {
		return labelOption;
	}

	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	public JTextField getTextFieldOption() {
		return textFieldOption;
	}

	public JTextField getTextFieldNumero() {
		return textFieldNumero;
	}

	public JTextField getTextFieldRue() {
		return textFieldRue;
	}

	public JTextField getTextFieldVille() {
		return textFieldVille;
	}

	public JTextField getTextFieldCodePostal() {
		return textFieldCodePostal;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
