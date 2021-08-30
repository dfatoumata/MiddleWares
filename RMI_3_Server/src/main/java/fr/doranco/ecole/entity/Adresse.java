package fr.doranco.ecole.entity;

import java.io.Serializable;

public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer numero;
	private String rue;
	private String ville;
	private Integer codePostal;
	
	public Adresse() {
	
	}
	public Adresse(Integer id, Integer numero, String rue, String ville, Integer codePostal) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
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
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

}
