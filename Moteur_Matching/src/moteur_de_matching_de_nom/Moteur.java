package moteur_de_matching_de_nom;

import java.util.ArrayList;
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
	
	public Moteur (GenerateurDeCondidat genCond, SelectionneurDeResultat selectRes, Comparateur_nom compNom,Recuperateur fich, Configuration config, Preprocesseur preProc) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.preProc=preProc;
		this.config=config;
		this.fich=fich;
	}
	
	public List<Preprocesseur> rechercher(String nom, List<String> l) {
			List <Preprocesseur> list = new ArrayList<Preprocesseur>();
			if (this.preProc.estPrétraiter()==false) {
				list=preProc.prétraiter(l);
			}
			
		    List<Preprocesseur> candidat = this.genCond.generUnCondidat(list,nom);
		    return this.selectRes.selectionner(candidat);
	}
	
	public List<String> dedupliquer(List<String> l){
		   
		}
	
	
	public List<String> comparer(List<String> l1, List<String> l2){
		
	}
}
