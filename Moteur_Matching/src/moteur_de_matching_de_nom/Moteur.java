package moteur_de_matching_de_nom;

import java.util.List;

public class Moteur {
	GenerateurDeCondidat genCond;
	SelectionneurDeResultat selectRes;
	Comparateur_nom compNom;
	Recuperateur fich;
	Configuration config;
	Preprocesseur preProc;
	
	public Moteur (GenerateurDeCondidat genCond, SelectionneurDeResultat selectRes, Comparateur_nom compNom) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
	}
	
	public boolean rechercher(String nom, List<String> l) {
		
	}
	
	public List<String> dedupliquer(List<String> l){
		
	}
	
	public List<String> comparer(List<String> l1, List<String> l2){
		
	}
}
