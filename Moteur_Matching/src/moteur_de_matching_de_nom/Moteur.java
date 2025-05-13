package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Moteur {

	private GenerateurDeCandidat genCond;
	private SelectionneurDeResultat selectRes;
	private ComparateurNom compNom;
	//private RécupérateurListCSV fich;
	private Configuration config;

	
	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
	}
	   

	public Moteur (GenerateurDeCandidat genCond, SelectionneurDeResultat selectRes, ComparateurNom compNom, Configuration config) {
		this.compNom=compNom;
		this.genCond=genCond;
		this.selectRes=selectRes;
		this.config=config;
	}
	

	
	
	public List<IdNomScore> rechercher(Nom nom, List<Nom> l) {
		
		List <Nom> ListDeNom = new ArrayList<Nom>();
		ListDeNom.add(nom);
		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		List <IdNomScore> candidatSéléctionner  = new ArrayList<IdNomScore>();
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(ListDeNom,l);
		for(CoupleDeNom couple : candidat) {
			Nom nom1 = couple.getNom1();
			Nom nom2 = couple.getNom2();
			nom1.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom1));
			nom2.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom2));
		}
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1(), couple.getNom2());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		
		candidatSéléctionner=this.selectRes.selectionner(candidatComparé);
		return candidatSéléctionner;	
	}
	
	public List<Nom> dedupliquer(List<Nom> l){
	
		    Set<String> valeurs = new HashSet<>();
		    Set<Nom> doublons = new HashSet<>();

		    for (Nom nom : l) {
		        //String normalisée = nom.getNomOriginal().trim().toLowerCase();
		        nom.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom));
		        // Si la valeur normalisée est déjà présente on l'insère dans doublon
		        if (!valeurs.add(nom.getNomOriginal())) {
		            doublons.add(nom);
		        }
		    }

		    return new ArrayList<>(doublons);
		}


	
	
	public List<CoupleDeNomAvecScore> comparer(List<Nom> l1, List<Nom> l2){

		List <CoupleDeNom> candidat = new ArrayList<CoupleDeNom>();
		
		List <CoupleDeNomAvecScore> candidatComparé = new ArrayList<CoupleDeNomAvecScore>();
		candidat = this.genCond.genererUnCandidat(l1,l2);
		for(CoupleDeNom couple : candidat) {
			Nom nom1 = couple.getNom1();
			Nom nom2 = couple.getNom2();
			nom1.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom1));
			nom2.setListDeNomPretraite(this.config.getNomProcesseur().prétraiter(nom2));
		}
		for (CoupleDeNom couple : candidat) {
			double score=compNom.comparerNom(couple.getNom1(), couple.getNom2());
			CoupleDeNomAvecScore coupleEtScore = new CoupleDeNomAvecScore(couple.getNom1(),couple.getNom2(), score);
			candidatComparé.add(coupleEtScore);
		}
		return candidatComparé;
		
	}
}
