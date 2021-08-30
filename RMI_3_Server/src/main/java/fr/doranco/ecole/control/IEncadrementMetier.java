package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.util.List;

import fr.doranco.ecole.entity.Cours;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;

public interface IEncadrementMetier {

	List<Etudiant> getListeEtudiantsByEnseignant(Enseignant enseignant) throws RemoteException;
	List<Enseignant> getListeEnseignantsByEtudiant(Etudiant etudiant) throws RemoteException;
	List<Cours> getListeCoursByEtudiant(Etudiant etudiant) throws RemoteException;
	List<Cours> getListeCoursByEnseignant(Enseignant enseignant) throws RemoteException;
	List<Etudiant> getListeEtudiantsByCours(Cours cours) throws RemoteException;
	List<Enseignant> getListeEnseignantsByCours(Cours cours) throws RemoteException;
}
