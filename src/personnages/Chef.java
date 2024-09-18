package personnages;

public class Chef {
	private String nom;
	private int force;
	private Village village;
	
	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte);
		
	}

	private String prendreParole() {
		return "Le Chef" + nom + ":";
		
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie in grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
		
	}
}
