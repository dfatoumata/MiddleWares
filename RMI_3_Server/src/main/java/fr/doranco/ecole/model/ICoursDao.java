package fr.doranco.ecole.model;

import java.rmi.RemoteException;

import fr.doranco.ecole.entity.Cours;

public interface ICoursDao {
	
	Cours getCoursById() throws RemoteException;
	Cours getCoursByTitre() throws RemoteException;
	Cours getCoursByType() throws RemoteException;
	Cours addCours() throws RemoteException;
	void updateCours() throws RemoteException;
	void removeCours() throws RemoteException;

}
