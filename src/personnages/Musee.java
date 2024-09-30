package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees;
	
	public void donnerTrophee(Gaulois donnateur, Equipement don) {
		Trophee nouveau = new Trophee(donnateur, don);
		trophees[nbTrophees] = nouveau;
		nbTrophees ++;
		
	}
	
	public String extraireInstructionsOCaml() {
		String declaration = "let musee = { ";
		for (int i = 0; i < nbTrophees; i++) {
			declaration += "\n \t \"" + trophees[i].donnerNom() +
					"\", \""+ trophees[i].getEquipement().getNom() + "\";";
		}
		declaration += "\n}";
		return declaration;
	}
}
