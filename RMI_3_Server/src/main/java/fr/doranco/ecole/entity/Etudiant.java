package fr.doranco.ecole.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Etudiant implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nom;
	private String prenom;
	private String specialite;
	private Integer  age;
	private String telephone;
	private String email;
	private Adresse Adresse;
	private Integer  section;
	private Integer  groupe;
	private List<Cours> listeCoursSuivis;
	
	public Etudiant() {
		this.listeCoursSuivis = new ArrayList<Cours>();
	}

	public Etudiant(String nom, String prenom, String specialite) {
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.listeCoursSuivis = new ArrayList<Cours>();
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
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

	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public Integer getGroupe() {
		return groupe;
	}

	public void setGroupe(Integer groupe) {
		this.groupe = groupe;
	}

	public List<Cours> getListeCoursSuivis() {
		return listeCoursSuivis;
	}


	

}
