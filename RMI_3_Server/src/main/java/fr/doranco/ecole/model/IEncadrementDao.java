package fr.doranco.ecole.model;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import fr.doranco.ecole.entity.Cours;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;

public interface IEncadrementDao {

	Set<Etudiant> getListeEtudiantsByEnseignant(Enseignant enseignant) throws RemoteException;
	Set<Enseignant> getListeEnseignantsByEtudiant(Etudiant etudiant) throws RemoteException;
	Set<Cours> getListeCoursByEtudiant(Etudiant etudiant) throws RemoteException;
	Set<Cours> getListeCoursByEnseignant(Enseignant enseignant) throws RemoteException;
	Set<Etudiant> getListeEtudiantsByCours(Cours cours) throws RemoteException;
	Set<Enseignant> getListeEnseignantsByCours(Cours cours) throws RemoteException;
}
