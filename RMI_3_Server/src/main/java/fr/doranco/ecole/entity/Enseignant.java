package fr.doranco.ecole.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enseignant implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nom;
	private String prenom;
	private String poste;
	private Integer  age;
	private String telephone;
	private String email;
	private Adresse Adresse;
	private List<Cours> listeCoursAssures;
	
	public Enseignant() {
		this.listeCoursAssures = new ArrayList<Cours>();
	}
	public Enseignant(String nom, String prenom, String poste) {
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.listeCoursAssures = new ArrayList<Cours>();

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adresse getAdresse() {
		return Adresse;
	}
	public void setAdresse(Adresse adresse) {
		Adresse = adresse;
	}
	public List<Cours> getListeCoursAssures() {
		return listeCoursAssures;
	}
	
	

}
