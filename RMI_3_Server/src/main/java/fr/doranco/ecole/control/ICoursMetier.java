package fr.doranco.ecole.control;

import java.rmi.RemoteException;

import fr.doranco.ecole.entity.Cours;

public interface ICoursMetier {
	
	Cours getCoursById() throws RemoteException;
	Cours getCoursByTitre() throws RemoteException;
	Cours getCoursByType() throws RemoteException;
	Cours addCours() throws RemoteException;
	void updateCours() throws RemoteException;
	void removeCours() throws RemoteException;

}
