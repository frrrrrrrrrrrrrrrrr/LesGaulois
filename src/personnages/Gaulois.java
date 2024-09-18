package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	
	public void parler(String texte) {
		String parole = prendreParole();
		System.out.println(parole + texte);
		
		
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + ": ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
		
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix +" "+ asterix.getNom());
		System.out.println(asterix.prendreParole());
		asterix.parler("Hello");
		
		Romain victime = new Romain("Victime", 5);
		asterix.frapper(victime);
	}
}
