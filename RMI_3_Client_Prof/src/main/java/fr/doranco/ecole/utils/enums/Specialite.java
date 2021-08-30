package fr.doranco.ecole.utils.enums;

public enum Specialite {

	MECANIQUE ("Mécanique"),
	INFORMATIQUE ("Informatique"),
	ELECTRONIQUE ("Electronique"),
	BIOLOGIE ("Biologie");
	
	private String specialite;
	
	Specialite(String specialite) {
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}
	
}
