package moteur_de_matching_de_nom;
import java.util.List;

public class SelectionneurAvecMaxResultat implements SelectionneurDeResultat {
	
	private int maxResultat;
	
	public SelectionneurAvecMaxResultat(int maxResultat) {
		this.maxResultat=maxResultat;
	}
	
	public List<CoupleDeNomAvecScore> selectionner(List<CoupleDeNomAvecScore> List1){
		
		return List1.subList(0, maxResultat);
	}

}
