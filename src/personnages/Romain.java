package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("Force n�gative " + force);
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
			throw new IllegalArgumentException("Force n�gative " + force);
		}
		int ancienneForce = force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		
		if(ancienneForce <= force) {
			throw new IllegalArgumentException("La force du romain n'a pas diminu�e " + ancienneForce + " -> " + force);
		}
	}
	
	public static void main(String[] args) {
		Romain claude = new Romain("Claude", 4);
		System.out.println(claude.prendreParole());
		claude.parler("hello");
		claude.recevoirCoup(3);
		claude.recevoirCoup(2);
		
	}
	
}
