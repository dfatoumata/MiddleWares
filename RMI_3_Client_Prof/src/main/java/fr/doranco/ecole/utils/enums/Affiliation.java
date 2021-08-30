package fr.doranco.ecole.utils.enums;

public enum Affiliation {

	AUCUN ("Aucun"),
	SPECIALITE ("Sp�cialit�"),
	GROUPE ("Groupe"),
	SECTION ("Section");
	
	private String affiliation;

	 Affiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getAffiliation() {
		return affiliation;
	}
	
}
