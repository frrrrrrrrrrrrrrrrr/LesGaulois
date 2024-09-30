package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private static String soldat = "Le soldat ";
	private boolean vaincu = false;
	

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert verifierForce();
	}

	public String getNom() {
		return nom;
	}
	
	
	
	public boolean isVaincu() {
		return vaincu;
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+ texte);
	}

	private String prendreParole() {
		return "Le Romain " + nom + ": ";
	}
	
	private boolean verifierForce() {
		return force >= 0;
	}
	
	
//	public void recevoirCoup( int forceCoup) {
//		assert verifierForce();
//		}
//		int ancienneForce = force;
//		
//		force -= forceCoup;
//		assert verifierForce();
//		if (force > 0) {
//			parler("Aï¿½e");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//		assert force < ancienneForce;
//	}
	
	public void sEquiper(Equipement equipement){
		
		switch(nbEquipement) {
		case 2:
			System.out.println(soldat + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(soldat + nom + " possède déja un " + equipement.getNom());
			} else {
				equiper(equipement);
			}
			break;
		default:
			equiper(equipement);
			break;
		}
	}
	
	private void equiper(Equipement equipement) {
		System.out.println(soldat + nom + " s'équipe d'un " + equipement.getNom());
		equipements[nbEquipement] = equipement;
		nbEquipement ++;
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition 
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup; 
		// if (force > 0) { 
		// parler("Aïe"); 
		// } else { 
		// equipementEjecte = ejecterEquipement(); 
		// parler("J'abandonne..."); 
		// }
		if (force >= 0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			vaincu = true;
		} 
		// post condition la force a diminuée 
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
					}
				else {
					if (equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
						System.out.println("Equipement casque");
						resistanceEquipement += 5; 
					}
				}
				
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup <0) {
			forceCoup = 0;
		}
		return forceCoup; 
		}
	
	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		//TODO 
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				} 
			}
		return equipementEjecte; 
		}
	
	public static void main(String[] args) {
		Romain claude = new Romain("Claude", 4);
		System.out.println(claude.prendreParole());
		claude.parler("hello");
		claude.recevoirCoup(3);
		claude.recevoirCoup(2);
		
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println(bouclier);
		Equipement casque = Equipement.CASQUE;
		
		claude.sEquiper(casque);
		claude.sEquiper(casque);
		claude.sEquiper(bouclier);
		claude.sEquiper(casque);
	}

	public int getForce() {
		return force;
	}
	
}
