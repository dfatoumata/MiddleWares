package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.util.List;

import fr.doranco.ecole.entity.Etudiant;

public interface IEtudiantMetier {

	Etudiant getEtudiantById(Integer id) throws RemoteException;

	Etudiant addEtudiant(Etudiant etudiant) throws RemoteException;

	void updateEtudiant(Etudiant etudiant) throws RemoteException;

	void removeEtudiant(Etudiant etudiant) throws RemoteException;

	List<Etudiant> getListeEtudiantsByGroupe() throws RemoteException;

	List<Etudiant> getListeEtudiantsBySection() throws RemoteException;

	List<Etudiant> getListeEtudiantsBySpecialite() throws RemoteException;
}
