package moteur_de_matching_de_nom;
import java.util.ArrayList;
import java.util.List;


public class ProgrammePrincipal {

	public static void main(String[] args) {
		Nom monNom = new Nom("ahmed ben ahmed","1");
		Nom nom1 = new Nom("ahmad ben ahmed","2");
		Nom nom2 = new Nom("mhamed ben ahmad","3");
		Nom nom3 = new Nom("ahlem","4");
		Nom nom4 = new Nom("ahmet","5");
		Nom nom5 = new Nom("ahmat","6");
		Nom nom6 = new Nom("ahcène","7");
		Nom nom7 = new Nom("ahmed ben ahmed","8");
		Nom nom8 = new Nom("ahmed","10");
		Nom nom9 = new Nom("ahmad ben ahmed","2");
	
		List <Nom> listDeNom = new ArrayList<Nom>();
		List <Nom> listDeNom1 = new ArrayList<Nom>();
		List<Nom> listDeNomDédupliquée = new ArrayList<Nom>();
		List<Nom> list = new ArrayList<Nom>();
		Menu.main(args);
		//listDeNom.add(monNom);
		listDeNom.add(nom1);
		listDeNom.add(nom9);
		listDeNom.add(nom3);
		listDeNom.add(nom4);
		listDeNom.add(nom5);
		listDeNom.add(nom6);
		listDeNom.add(nom7);
		listDeNom.add(nom8);
		listDeNom.add(nom8);
		listDeNom.add(nom2);
		/////
		listDeNom1.add(nom7);
		listDeNom1.add(nom5);
		listDeNom1.add(nom2);
		listDeNom1.add(nom1);
		listDeNom1.add(nom3);
		listDeNom1.add(nom4);
		
		
		
		// liste de recherche avec un comparateur de nom utilisant un comparateur avec equals()
		List <IdNomScore> Listfinale = new ArrayList<IdNomScore>();
		ComparateurNomSansComparateurDeChaine comparateurNom = new ComparateurNomSansComparateurDeChaine();
		SelectionneurDeRésultatSansOptions selectionneur = new SelectionneurDeRésultatSansOptions();
		
		
		//SelectionneurParSeuil selectionneur = new SelectionneurParSeuil(0.5);
		//SelectionneurAvecMaxResultat selectionneur = new SelectionneurAvecMaxResultat(4);
		//JaroWinkler comchaine = new JaroWinkler();
		//Levenshtein compchaine = new Levenshtein();
		//ComparateurNomAvecComparateurChaine comparateurNom = new ComparateurNomAvecComparateurChaine(comchaine);

		
		//un générateur de condidat selon la taile de la chaine
		GenerateurDeCandidatSelonLaTaille genCand = new GenerateurDeCandidatSelonLaTaille();
		GenerateurDeCandidat genCandidat = (GenerateurDeCandidat) genCand;
		
		SelectionneurDeResultat selector1 = (SelectionneurDeResultat) selectionneur;
		ComparateurNom compNom = (ComparateurNom) comparateurNom;
		
		
		
	
		Moteur moteur = new Moteur(genCandidat,selector1,compNom);
		
		Listfinale= moteur.rechercher(monNom, listDeNom);
		System.out.println("Résultat de recherche de "+monNom.getNomOriginal()+": ");
		for (IdNomScore element : Listfinale) {
		    System.out.println(element.toString());
		}
		
		listDeNomDédupliquée=moteur.dedupliquer(listDeNom);
		System.out.println("Résultat de la déduplication:");
		for (Nom element : listDeNomDédupliquée) {
		    System.out.println(element.toString());
		}
		
		list=moteur.comparer(listDeNom1, listDeNom);
		System.out.println("Résultat de comparaison:");
		for (Nom element : list) {
		    System.out.println(element.toString());
		}
		
	}
}
		
		
		
		
		
		
	


