package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.util.List;

import fr.doranco.ecole.entity.Enseignant;

public interface IEnseignantMetier {

	Enseignant getEnseignantById(Integer id) throws RemoteException;
	Enseignant addEnseignant(Enseignant enseignant) throws RemoteException;
	void updateEnseignant(Enseignant enseignant) throws RemoteException;
	void removeEnseignant(Enseignant enseignant) throws RemoteException;
	List<Enseignant> getListeEnseignantsByGroupe() throws RemoteException;
}
