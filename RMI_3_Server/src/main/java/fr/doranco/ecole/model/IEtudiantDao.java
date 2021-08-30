package fr.doranco.ecole.model;

import java.util.List;

import fr.doranco.ecole.entity.Etudiant;

public interface IEtudiantDao {

	Etudiant getEtudiantById(Integer id) throws Exception;

	Etudiant addEtudiant(Etudiant etudiant) throws Exception;

	void updateEtudiant(Etudiant etudiant) throws Exception;

	void removeEtudiant(Etudiant etudiant) throws Exception;

	List<Etudiant> getListeEtudiantsByGroupe() throws Exception;

	List<Etudiant> getListeEtudiantsBySection() throws Exception;

	List<Etudiant> getListeEtudiantsBySpecialite() throws Exception;
}
