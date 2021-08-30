package fr.doranco.ecole.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Enseignant implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private String poste;
	private Adresse adresse;
	private Set<Cours> cours;
	
	public Enseignant() {
		this.cours = new HashSet<Cours>();
	}

	public Enseignant(String nom, String prenom, String poste) {
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
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
