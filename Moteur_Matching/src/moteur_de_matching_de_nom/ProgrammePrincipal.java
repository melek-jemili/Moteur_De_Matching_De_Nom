package moteur_de_matching_de_nom;

import java.util.List;
import java.util.ArrayList;
public class ProgrammePrincipal {

	public static void main(String[] args) {
		Nom monNom = new Nom("melek","1");
		Nom nom1 = new Nom("malek","10");
		Nom nom2 = new Nom("malak","11");
		Nom nom3 = new Nom("maher","100");
		Nom nom4 = new Nom("malik","110");
		Nom nom5 = new Nom("maha","111");
		Nom nom6 = new Nom("mehrez","1000");
		List <Nom> listDeNom = new ArrayList<Nom>();
		//listDeNom.add(monNom);
		listDeNom.add(nom1);
		listDeNom.add(nom2);
		listDeNom.add(nom3);
		listDeNom.add(nom4);
		listDeNom.add(nom5);
		listDeNom.add(nom6);
		// liste de recherche avec un comparateur de nom utilisant Levenshtein
		List <CoupleDeNomAvecScore> Listfinale = new ArrayList<CoupleDeNomAvecScore>();
		Levenshtein compNomLeven= new Levenshtein();
		ComparateurChaine compNomLevenshtein = (ComparateurChaine) compNomLeven;
		//ComparateurNomAvecComparateurChaine comNom = new ComparateurNomAvecComparateurChaine(compNomLeven);
		
		//liste de recherche de nom avec un comparateur de nom utilisant JaroWinkler
		JaroWinkler jaro = new JaroWinkler();
		ComparateurChaine compNomJaro = (ComparateurChaine) jaro;
		ComparateurNomAvecComparateurChaine comNom = new ComparateurNomAvecComparateurChaine(compNomJaro);
		
		
		//SelectionneurAvecMaxResultat select = new SelectionneurAvecMaxResultat(5);
		SelectionneurParSeuil selecteur = new SelectionneurParSeuil(0.1);
		GenerateurDeCandidatSelonLaTaille genCand = new GenerateurDeCandidatSelonLaTaille();
		
		
		GenerateurDeCandidat genCandidat = (GenerateurDeCandidat) genCand;
		//SelectionneurDeResultat selector = (SelectionneurDeResultat) select;
		SelectionneurDeResultat selector1 = (SelectionneurDeResultat) selecteur;
		ComparateurNom compNom = (ComparateurNom) comNom;
		
		
		
	
		Moteur moteur = new Moteur(genCandidat,selector1,compNom);
		
		Listfinale= moteur.rechercher(monNom, listDeNom);
		System.out.println("Résultat de recherche de "+monNom.getNomOriginal()+": ");
		for (CoupleDeNomAvecScore element : Listfinale) {
		    System.out.println(element.toString());
		}
		
		
		
		
		
	}

}
