package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte);
		
	}

	private String prendreParole() {
		return "Le druide " + nom + ": ";
	}
	
	public void preparerPotion() {
		Random chaudron = new Random();
		int potion = chaudron.nextInt(effetPotionMax - effetPotionMin) + effetPotionMin;
		forcePotion = potion;
		if (potion >7) {
			parler("J'ai préparé une super potion de force " + potion);
			
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + potion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
			
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public int getEffetPotionMin() {
		return effetPotionMin;
	}

	public int getEffetPotionMax() {
		return effetPotionMax;
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}


}
