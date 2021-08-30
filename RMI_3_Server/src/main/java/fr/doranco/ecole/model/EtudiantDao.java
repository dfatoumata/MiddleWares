package fr.doranco.ecole.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.doranco.ecole.entity.Etudiant;

public class EtudiantDao implements IEtudiantDao {
		
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		if (etudiant == null  || etudiant.getNom() == null || etudiant.getNom().isEmpty() 
				|| etudiant.getPrenom() == null || etudiant.getPrenom().isEmpty()
				|| etudiant.getSpecialite() == null || etudiant.getSpecialite().isEmpty()) {

			throw new IllegalArgumentException("Les paramètres ne doivent pas être nuls ou vides !");
		}

		Connection connexion = null;
		try {
			connexion = EcoleDataSource.getConnexion();
			String requete = "INSERT INTO etudiant (nom, prenom, specialite)"
					+ "VALUES(?, ?, ?)";
			PreparedStatement ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getSpecialite());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				etudiant.setId(rs.getInt("0"));
			}

		} finally {
			if (connexion != null) {
				connexion.close();
			}
		}
		return etudiant;
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
