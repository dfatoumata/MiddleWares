package fr.doranco.ecole.control;

import java.rmi.RemoteException;
import java.util.List;

import fr.doranco.ecole.entity.Cours;
import fr.doranco.ecole.entity.Enseignant;
import fr.doranco.ecole.entity.Etudiant;

public class EncadrementMetier implements IEncadrementMetier {

	@Override
	public List<Etudiant> getListeEtudiantsByEnseignant(Enseignant enseignant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> getListeEnseignantsByEtudiant(Etudiant etudiant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getListeCoursByEtudiant(Etudiant etudiant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getListeCoursByEnseignant(Enseignant enseignant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> getListeEtudiantsByCours(Cours cours) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> getListeEnseignantsByCours(Cours cours) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
