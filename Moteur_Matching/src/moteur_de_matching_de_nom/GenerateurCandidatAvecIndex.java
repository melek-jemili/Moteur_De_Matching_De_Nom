package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateurCandidatAvecIndex implements GenerateurDeCandidat{
	
	private Indexeur index;
	
	public GenerateurCandidatAvecIndex(Indexeur index) {
		this.index=index;
		
	}
	
	public List <CoupleDeNom> genererUnCandidat(List <Nom> list1 ,List<Nom> list2){
		List<Nom> liste = new ArrayList<Nom>();
		List<String> listeDeNomOriginal = new ArrayList<String>();
		Map<Integer, String> map = new HashMap<Integer, String>();
		liste.addAll(list1);
		liste.addAll(list2);
		
		for(Nom nom : liste) {
			listeDeNomOriginal.add(nom.getNomOriginal());
		}
		this.index.indexer(listeDeNomOriginal);
		
	}

}
