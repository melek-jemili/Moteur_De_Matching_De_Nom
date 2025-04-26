package moteur_de_matching_de_nom;

public class  ComparateurNomAvecComparateurChaine extends Comparateur_nom {
	
	Comparateur_chaine ch;
	
	public double comparerNom(String nom1, String nom2) {
		
		return ch.comparer(nom1, nom2);
		
	}

}
