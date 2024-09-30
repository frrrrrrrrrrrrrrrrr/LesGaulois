package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees;
	
	public void donnerTrophees(Gaulois donnateur, Equipement don) {
		Trophee nouveau = new Trophee(donnateur, don);
		trophees[nbTrophees] = nouveau;
		nbTrophees ++;
		
	}
}
