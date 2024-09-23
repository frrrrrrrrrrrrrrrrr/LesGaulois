package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}
	
	
	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
		
	}
	
	public Gaulois trouverHabitant(int num) {
		return villageois[num];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaire gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("\t- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		
		//Gaulois gaulois = village.trouverHabitant(30);
		//La case d'indice 30 du tableau n'existe pas ( on depasse le tableau)
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix); 
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		// La case d'indice 1 est vide

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
		
	}
}
