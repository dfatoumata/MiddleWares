package fr.doranco.ecole.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;

public interface IEncadrementRmi extends Remote {

	Set<Etudiant> getEtudiantsByEnseignant(Integer idEnseignant) throws RemoteException;
	Set<Enseignant> getEnseignantsByEtudiant(Integer idEtudiant) throws RemoteException;

}
