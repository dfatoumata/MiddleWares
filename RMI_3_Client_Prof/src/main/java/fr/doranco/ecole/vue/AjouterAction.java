package fr.doranco.ecole.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.rmi.ConnectException;
import java.rmi.Naming;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.doranco.ecole.entity.Adresse;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;
import fr.doranco.ecole.rmi.interfaces.IEtudiantRmi;

public class AjouterAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private FenetrePrincipale fenetre;
	
	public AjouterAction(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		fenetre.getTextArea().setText("");
		fenetre.getTextArea().setForeground(Color.blue);
		String title = "Ajout : Nouveau " + (fenetre.getRadioButtonEtudiant().isSelected() ? "Etudiant" : "Enseignant");
		String message = "";
		boolean saisieComplete = (!fenetre.getTextFieldFirstName().getText().isEmpty()
				&& !fenetre.getTextFieldLastName().getText().isEmpty() && !fenetre.getTextFieldOption().getText().isEmpty()
				&& !fenetre.getTextFieldNumero().getText().isEmpty() && !fenetre.getTextFieldRue().getText().isEmpty()
				&& !fenetre.getTextFieldVille().getText().isEmpty() && !fenetre.getTextFieldCodePostal().getText().isEmpty());
		if (!saisieComplete) {
			message = "Tous les champs sont obligatoires";
			JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
			return;
		}
		String codePostal = fenetre.getTextFieldCodePostal().getText();
		Integer numero = null;
		try {
			numero = Integer.parseInt(fenetre.getTextFieldNumero().getText());
		}
		catch(NumberFormatException except) {
			message = "Le champ Numéro doit être numérique";
			JOptionPane.showMessageDialog(null, message, "Ajout : " + title, JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Adresse adresse = new Adresse();
		adresse.setNumero(numero);
		adresse.setRue(fenetre.getTextFieldRue().getText());
		adresse.setVille(fenetre.getTextFieldVille().getText());
		adresse.setCodePostal(codePostal);
		
		try {
			if (fenetre.getRadioButtonEtudiant().isSelected()) {
				
				Etudiant etudiant = new Etudiant();
				etudiant.setNom(fenetre.getTextFieldFirstName().getText());
				etudiant.setPrenom(fenetre.getTextFieldLastName().getText());
				etudiant.setSpecialite(fenetre.getTextFieldOption().getText());
				etudiant.setAdresse(adresse);
				
				IEtudiantRmi rmiEtudiant = (IEtudiantRmi) Naming.lookup("//localhost:1099/etudiant");
				Etudiant etudiantAjoute = rmiEtudiant.addEtudiant(etudiant);
	
				if (etudiantAjoute != null) {
					fenetre.getTextArea().setText("Etudiant ajouté avec succès !\n");
					fenetre.getTextArea().append("--------------------------------------------\n");
					fenetre.getTextArea().append("  Id : " + etudiantAjoute.getId() + "\n");
					fenetre.getTextArea().append("  Nom : " + etudiantAjoute.getNom() + "\n");
					fenetre.getTextArea().append("  Prénom : " + etudiantAjoute.getPrenom() + "\n");
					fenetre.getTextArea().append("  Spécialité : " + etudiantAjoute.getSpecialite() + "\n");
					fenetre.getTextArea().append("Adresse ajoutée avec succès !\n");
					fenetre.getTextArea().append("--------------------------------------------\n");
					fenetre.getTextArea().append("  Id : " + etudiantAjoute.getAdresse().getId() + "\n");
					fenetre.getTextArea().append("  Numéro : " + etudiantAjoute.getAdresse().getNumero() + "\n");
					fenetre.getTextArea().append("  Rue : " + etudiantAjoute.getAdresse().getRue() + "\n");
					fenetre.getTextArea().append("  Ville : " + etudiantAjoute.getAdresse().getVille() + "\n");
					fenetre.getTextArea().append("  Code postal : " + etudiantAjoute.getAdresse().getCodePostal() + "\n");
					return;
				} else {
					fenetre.getTextArea().setText("Ajout impossible de l'étudiant !!");
					fenetre.setForeground(Color.red);
				}
			}
//			if (fenetre.getRadioButtonEnseignant().isSelected()) {
//				Enseignant enseignant = new Enseignant();
//				enseignant.setNom(fenetre.getTextFieldFirstName().getText());
//				enseignant.setPrenom(fenetre.getTextFieldLastName().getText());
//				enseignant.setPoste(fenetre.getTextFieldOption().getText());
//				enseignant.setAdresse(adresse);
//	
//				Enseignant enseignantAjoute = null;
//				IEnseignantRmi rmiEnseignant = (IEnseignantRmi) Naming.lookup("//localhost:1099/enseignant");
//				enseignantAjoute = rmiEnseignant.addEnseignant(enseignant);
//				
//				fenetre.getTextArea().setText("Enseignant ajouté avec succès !\n");
//				fenetre.getTextArea().append("--------------------------------------------\n");
//				fenetre.getTextArea().append("  Id : " + enseignantAjoute.getId() + "\n");
//				fenetre.getTextArea().append("  Nom : " + enseignantAjoute.getNom() + "\n");
//				fenetre.getTextArea().append("  Prénom : " + enseignantAjoute.getPrenom() + "\n");
//				fenetre.getTextArea().append("  Poste : " + enseignantAjoute.getPoste() + "\n");
//				return;
//			}
		} catch(Exception except) {
			if (except instanceof ConnectException) {
				message = "Impossible de se connecter au serveur !";
				JOptionPane.showMessageDialog(null, message, "Erreur d'ajout !", JOptionPane.ERROR_MESSAGE);
			} else {
				message = "Erreur du serveur : Impossible d'ajouter l'étudiant/enseignant !";
				JOptionPane.showMessageDialog(null, message, "Erreur d'ajout !", JOptionPane.ERROR_MESSAGE);
			}
			System.err.println(except);
			return;
		}
	}

}
