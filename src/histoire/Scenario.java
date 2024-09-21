package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus = new Romain("Minus", 6);
		
		panoramix.parler("Bonjour, je suis le druide " + panoramix.getNom()+
				" et ma potion peut aller d'une force "+ panoramix.getEffetPotionMin()
				+ " à " + panoramix.getEffetPotionMax());
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		
		panoramix.booster(asterix);
		
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
		
		

	}

}
