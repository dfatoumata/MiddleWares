package fr.doranco.ecole.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.doranco.ecole.entity.Etudiant;

public interface IEtudiantRmi extends Remote {

	Etudiant addEtudiant(Etudiant etudiant) throws RemoteException;
}
