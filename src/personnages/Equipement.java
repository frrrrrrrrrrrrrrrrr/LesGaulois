package personnages;

public enum Equipement {
	CASQUE("casque"),
	BOUCLIER("bouclier");
	
	private String nom;
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return "Nom: " + nom;
	}

	public String getNom() {
		return nom;
	}
	
	
}
