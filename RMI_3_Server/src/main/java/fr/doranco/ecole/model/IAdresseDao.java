package fr.doranco.ecole.model;

import java.util.Set;

import fr.doranco.ecole.entity.Adresse;

public interface IAdresseDao {

	Adresse addAdresse(Adresse adresse) throws Exception;

	Adresse getAdresse(Integer id) throws Exception;

	void updateAdresse(Adresse adresse) throws Exception;

	void removeAdresse(Integer id) throws Exception;

	Set<Adresse> getAdressesUtilisateur(Integer id) throws Exception;

}
