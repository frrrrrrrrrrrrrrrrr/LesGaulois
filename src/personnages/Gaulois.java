package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force; 
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public void boirePotion(int effetPotion) {
		this.effetPotion = effetPotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
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

//	private String prendreParole() {
//		return "Le Gaulois " + nom + ": ";
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup(force / 3 * effetPotion);
//		
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesR = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesR != null && i < tropheesR.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesR[i]; 
			} 
	}
	
	public void faireUneDonnation(Musee musee) {
		String donations = "";
		if (nbTrophees > 0) {
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophee(this, trophees[i]);
				donations += "\n- " + trophees[i].getNom();
			}
			parler("Je donne au musee tous mes trophees :" + donations);
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		System.out.println(asterix +" "+ asterix.getNom());
		System.out.println(asterix.prendreParole());
		asterix.parler("Hello");
		
		Romain victime = new Romain("Victime", 5);
		asterix.frapper(victime);
		
		asterix.boirePotion(5);
		asterix.frapper(victime);
	}
}
