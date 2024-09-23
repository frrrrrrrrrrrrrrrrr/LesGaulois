package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("Force négative " + force);
		}
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ texte);
	}

	private String prendreParole() {
		return "Le Romain " + nom + ": ";
	}
	
	public void recevoirCoup( int forceCoup) {
		if(force<0) {
			throw new IllegalArgumentException("Force négative " + force);
		}
		int ancienneForce = force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aï¿½e");
		} else {
			parler("J'abandonne...");
		}
		
		if(ancienneForce <= force) {
			throw new IllegalArgumentException("La force du romain n'a pas diminuée " + ancienneForce + " -> " + force);
		}
	}
	
	public void sEquiper(Equipement equipement){
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déja un " + equipement.getNom());
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
		System.out.println("Le soldat " + nom + " s'équipe d'un " + equipement.getNom());
		equipements[nbEquipement] = equipement;
		nbEquipement ++;
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
	
}
