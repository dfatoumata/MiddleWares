package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.util.Set;

import fr.doranco.ecole.entity.Adresse;

public interface IAdresseMetier {

	Adresse addAdresse(Adresse adresse, Integer id) throws RemoteException;

	Adresse getAdresse(Integer id) throws RemoteException;

	void updateAdresse(Adresse adresse) throws RemoteException;

	void removeAdresse(Integer id) throws RemoteException;

	Set<Adresse> getAdressesUtilisateur(Integer id) throws RemoteException;

}
