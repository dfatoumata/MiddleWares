package fr.doranco.ecole.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Etudiant implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String prenom;
	private String specialite;
	private Adresse adresse;
	private Set<Cours> cours;
	
	public Etudiant() {
		this.cours = new HashSet<Cours>();
	}

	public Etudiant(String nom, String prenom, String specialite) {
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.cours = new HashSet<Cours>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Cours> getCours() {
		return cours;
	}

}
