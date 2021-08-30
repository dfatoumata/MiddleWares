package fr.doranco.ecole.entity;

import java.io.Serializable;

public class Adresse implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id;
	private int numero;
	private String rue;
	private String ville;
	private String codePostal;
	
	
	public Adresse() {
		
	}
	
	public Adresse(int numero, String rue, String ville, String codePostal) {
		
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id= id ;
	}
	
	
}
