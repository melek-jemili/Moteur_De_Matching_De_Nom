package moteur_de_matching_de_nom;
import java.util.ArrayList;
import  java.util.List;

public class GenerateurDeCondidat {
	
	Indexeur index;
	Preprocesseur preProcList;
	
	public GenerateurDeCondidat(Indexeur index, Preprocesseur preProcList) {
		this.index=index;
		this.preProcList=preProcList;
		
	}
	
	public List <Preprocesseur> generUnCondidat(List <String> list1 ,String nom ){
		List <Preprocesseur> listDeCandidat = new ArrayList<Preprocesseur>();
		List <String> listDeNom = new ArrayList<String>();
		listDeNom.add(nom);
		if (list1.contains(listDeNom)){
			
			 
		}
		
		return listDeCandidat;

	}
	
}
