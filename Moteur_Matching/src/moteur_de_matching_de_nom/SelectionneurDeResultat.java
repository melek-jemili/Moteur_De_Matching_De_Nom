package moteur_de_matching_de_nom;
import java.util.List;


public interface SelectionneurDeResultat {
	 
	
	List<CoupleDeNomAvecScore> selectionner(List<CoupleDeNomAvecScore>L);
	

}
 