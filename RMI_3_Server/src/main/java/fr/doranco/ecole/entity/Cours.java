package fr.doranco.ecole.entity;

import java.io.Serializable;

public class Cours implements Serializable {

	private static final long serialVersionUID = 1L;
     
	private Integer id;
	private String titre;
	private Integer duree;
	private String type;
	
	public Cours() {
	}
	public Cours(String titre, Integer duree, String type) {
		this.titre = titre;
		this.duree = duree;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}    
