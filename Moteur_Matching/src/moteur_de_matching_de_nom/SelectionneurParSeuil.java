package moteur_de_matching_de_nom;

import java.util.List;

public class SelectionneurParSeuil  implements SelectionneurDeResultat{
	
	private double seuil;
	
	public SelectionneurParSeuil(double seuil) {
		this.seuil=seuil;
	}
	
	public List<CoupleDeNomAvecScore> selectionner(List<CoupleDeNomAvecScore> List1){
		return List1;
	}

}
