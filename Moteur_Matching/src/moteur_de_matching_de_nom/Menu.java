package moteur_de_matching_de_nom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
        int choix;
        int choice;
        String nom;
        String path1;
        int maxresult =0;
        double seuil = 0.0;
        SelectionneurDeResultat selector = null;
        ComparateurNom compNom = null;
        GenerateurDeCandidat genCand = null;
        Preprocesseur preprocesseur = null;
        Indexeur index = null;
        ComparateurNom compChaine = null;
        
        //initialisation des parametres par defaut :
        
        //compNom = new ComparateurNomSansComparateurDeChaine();
        /*EncodeurPhonétique encod = new EncodeurPhonétique();
        
        liste=encod.prétraiter(liste1);*/
        
        /*Levenshtein lev = new Levenshtein();
        compChaine = new ComparateurNomAvecComparateurChaine(lev);
        
		selector = new SelectionneurDeRésultatSansOptions();
		genCand = new GenerateurDeCandidatSelonLaTaille();*/
		
		Moteur moteur = new Moteur(genCand,selector,compNom);
        List<IdNomScore> listeDeRecherche = new ArrayList<IdNomScore>();
        
        
        do {
        	System.out.println("-------------------------------------");
            System.out.println("========== MENU ==========");
            System.out.println("1. Configurer les paramètres");
            System.out.println("2. Effectuer une recherche");
            System.out.println("3. Comparer deux listes");
            System.out.println("4. Dédupliquer une liste");

            System.out.println("5. Quitter");
            System.out.println("-------------------------------------");
            System.out.print("Votre choix : ");
            
            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer le saut de ligne

            switch (choix) {
            
                case 2:
                	
                    System.out.println("Saisir  le nom à rechercher:");
                    nom= scanner.nextLine();

		            System.out.println("Fournir le fichier CSV:");
		            path1 = scanner.nextLine();		            
		            List<Nom> liste1 = new ArrayList<Nom>();		            
		            Nom nomAChercher = new Nom("0", nom);
		            
		            RécupérateurListCSV recuperateur1 = new RécupérateurListCSV(path1);
		            liste1=recuperateur1.récupérer();
		            System.out.println("Nombre d'éléments dans liste1: " + liste1.size());
					listeDeRecherche=moteur.rechercher(nomAChercher, liste1);
					System.out.println("Résultat de recherche de "+nomAChercher.getNomOriginal()+": ");
					for (IdNomScore element : listeDeRecherche) {
					    System.out.println(element.toString());
					}
					long start = 0;
					System.out.println("Durée : " + (System.nanoTime() - start) / 1_000_000.0 + " ms");

		                      
                    break;
                    
                case 3:
                	System.out.println("Fournir le premier fichier CSV:");
		            String path2 = scanner.nextLine();		            
		            System.out.println("Fournir le deuxième fichier CSV:");
		            String path3 = scanner.nextLine();		            
		            RécupérateurListCSV recuperateur2 = new RécupérateurListCSV(path2);
		            List<Nom>liste2=recuperateur2.récupérer();
		            RécupérateurListCSV recuperateur3 = new RécupérateurListCSV(path3);
		            List<Nom>liste3=recuperateur3.récupérer();
		            List<CoupleDeNomAvecScore> listeDeComparaison = moteur.comparer(liste2, liste3);
		            
		    		System.out.println("Résultat de comparaison:");
		    		System.out.println("Nombre de couples générés : " + listeDeComparaison.size());
		    		for (CoupleDeNomAvecScore element : listeDeComparaison) {
		    		    System.out.println(element.toString());
		    		}
		    		long start2=System.nanoTime();
		    		System.out.println("Durée : " + (System.nanoTime() - start2) / 1_000_000.0 + " ms");
		    		
		    		
                    break;
                    
                case 4:
                	System.out.println("Fournir le fichier CSV à traiter:");
		            String path4 = scanner.nextLine();		            
		            RécupérateurListCSV recuperateur4 = new RécupérateurListCSV(path4);
		            List<Nom>liste4=recuperateur4.récupérer();
		            List<Nom> listeDédupliquée = moteur.dedupliquer(liste4);
		            System.out.println("Résultat de la déduplication:");
		    		for (Nom element : listeDédupliquée) {
		    		    System.out.println(element.toString());
		    		}
		    		long start3=System.nanoTime();
		    		System.out.println("Durée : " + (System.nanoTime() - start3) / 1_000_000.0 + " ms");
		    		
		    		
                    break;
                case 5 :
                	
                	break;
                case 1:
                	do {
                	System.out.println("-------------------------------------");
                	System.out.println("======= Choisir votre configuration ======");              	
                	System.out.println("1. choisir le prétraitement "); 
                	System.out.println("2. choisir une structure d'index ");
                	System.out.println("3. choisir une mesure de comparaison ");
                    System.out.println("4. Définir un max de résultat ");
                	System.out.println("5. Définir un seuil ");
                	System.out.println("6. Retour au menu");
                	System.out.println("7.Choisir les selectionneurs et les generateurs");

                	System.out.println("-------------------------------------");
                	System.out.print("Votre choix : ");
                	choice = scanner.nextInt();
                    switch (choice) {
                    
                    	case 1 :
                    		preprocesseur = MenuPretraiteur.choisirPretraiteur(scanner);
                    		break;
                    	case 2 :
                    		index= MenuIndexeur.choisirIndexeur(scanner);
                    		break;
                    	case 3 :
                    		compChaine =  MenuComparateur.choisirComparateur(scanner);
                    		break;
                    	case 4 :
                    		System.out.print("Entrer le nombre maximum de résultats : ");
                    		 maxresult= scanner.nextInt();
                    		break;
                    	case 5:
                    		System.out.print("Entrer le seuil  : ");
                    		 seuil= scanner.nextDouble();
                    		break;
                    	case 7:
                    		do{
                        		System.out.println("-------------------------------------");
                        		System.out.println("1. choisir le Sélectionneur ");
                        		System.out.println("2. choisir le Générateur  ");
                        		System.out.println("3. Retour au menu");
                        		System.out.println("-------------------------------------");
                        		System.out.print("Votre choix : ");
                        		choice = scanner.nextInt();
                        		switch(choice) {
                        			case 1:
                        				selector = MenuSelectionneur.choisirSelectionneur(scanner);                	 
                        				break;
                        			case 2 :
                        				genCand = MenuGenerateurDeCnadidat.choisirGenerateur(scanner);
                        				break;
                        			case 3 :
                        				System.out.println("Retour au menu");
                        			default : 
                        				System.out.println("choix invalide");
                        		}
                        	moteur = new Moteur(genCand,selector,compNom);
                        	System.out.println("Moteur mis à jour avec les nouveaux paramètres.");
                        	}while(choice !=3);
                    		break ;
                    		
                    	case 6:
                    		System.out.println("Retour au menu");
                    		break;
                    	default:
                    		System.out.println("choix invalide.");
                    }
		            Configuration config = new Configuration(preprocesseur, index, compChaine, seuil, maxresult);
		            moteur = new Moteur(genCand, selector, compChaine, config);
		            System.out.println("Configuration mise à jour.");
                	
                	}while(choice !=6);
                	break;
                case 6:
                	System.out.println("Quitter");
                	break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }

            System.out.println(); // ligne vide pour l'affichage

        } while (choix != 6);

        scanner.close();
    }
}