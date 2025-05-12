package moteur_de_matching_de_nom;

import java.util.Scanner;

public class MenuGenerateurDeCnadidat {

	public static GenerateurDeCandidat choisirGenerateur(Scanner scanner) {
		
		GenerateurDeCandidat generateur = null;
		
		System.out.println("--- MENU GENERATEUR DE CANDIDAT ---");
        System.out.println("1. Générateur de candidat par index");
        System.out.println("2. Génerateur de candidat Trivial");
        System.out.println("3. Générateur de candidat selon la taille ");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
            	IndexDictionnaire index = new IndexDictionnaire();
            	generateur = new GenerateurCandidatAvecIndex(index);
                break;
                
            case 2:
            	generateur = new GenerateurDeCandidatTrivial();
            	break;
            	
            case 3:
            	generateur = new GenerateurDeCandidatSelonLaTaille();          	
            	break;
            	
            default:
                System.out.println("Choix invalide ! ");
        }
        return generateur;
    }
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        GenerateurDeCandidat generateur = choisirGenerateur(scanner);

	        if (generateur != null) {
	            System.out.println("Générateur sélectionné : " + generateur.getClass().getSimpleName());
	        } else {
	            System.out.println("Aucun générateur n'a été sélectionné.");
	        }

	        scanner.close();
	    }
	
}

