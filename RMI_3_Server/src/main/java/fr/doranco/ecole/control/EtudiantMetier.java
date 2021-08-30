package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.doranco.ecole.entity.Etudiant;
import fr.doranco.ecole.model.EtudiantDao;

public class EtudiantMetier implements IEtudiantMetier {
	
	IAdresseMetier adresseMetier = new AdresseMetier();
	EtudiantDao etudiantDao = new EtudiantDao();
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws RemoteException {
		
			if (etudiant.getAdresse() != null || etudiant.getAdresse().getNumero() != null 
					|| etudiant.getAdresse().getRue() != null  || etudiant.getAdresse().getVille() != null
					|| etudiant.getAdresse().getCodePostal() != null ) {
				
				adresseMetier.addAdresse(etudiant.getAdresse(), etudiant.getId());
				

			}			

			Etudiant etudiantAjoute = null;
		try {
			etudiantAjoute = etudiantDao.addEtudiant(etudiant);
			return etudiantAjoute;
		} catch (Exception e) {
			return new RemoteException("");
		}
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateEtudiant(Etudiant etudiant) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEtudiant(Etudiant etudiant) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Etudiant> getListeEtudiantsByGroupe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> getListeEtudiantsBySection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> getListeEtudiantsBySpecialite() {
		// TODO Auto-generated method stub
		return null;
	}


}
