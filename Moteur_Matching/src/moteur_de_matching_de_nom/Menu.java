package moteur_de_matching_de_nom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
	

		        Scanner scanner = new Scanner(System.in);
		        int choix;
		        String nom;
		        String path1;
				ComparateurNomSansComparateurDeChaine comparateurNom = new ComparateurNomSansComparateurDeChaine();
				SelectionneurDeRésultatSansOptions selectionneur = new SelectionneurDeRésultatSansOptions();
				GenerateurDeCandidatSelonLaTaille genCand = new GenerateurDeCandidatSelonLaTaille();
				GenerateurDeCandidat genCandidat = (GenerateurDeCandidat) genCand;
				
				SelectionneurDeResultat selector1 = (SelectionneurDeResultat) selectionneur;
				ComparateurNom compNom = (ComparateurNom) comparateurNom;
				List<IdNomScore> listeDeRecherche = new ArrayList<IdNomScore>();
				Moteur moteur = new Moteur(genCandidat,selector1,compNom);

		        do {
		            System.out.println("=== MENU ===");
		            System.out.println("1.Effectuer une recherche");
		            System.out.println("2. Comparer deux listes");
		            System.out.println("3. Dédupliquer une liste");
		            System.out.println("4. Configurer les paramètres");
		            System.out.println("5. Quitter");
		            System.out.print("Votre choix : ");
		            
		            choix = scanner.nextInt();
		            scanner.nextLine(); // pour consommer le saut de ligne

		            switch (choix) {
		            
		                case 1:
		                	
		                    System.out.println("Saisir  le nom à rechercher:");
		                    nom= scanner.nextLine();
				            scanner.nextLine();
				            System.out.println("Fournir le fichier CSV:");
				            path1 = scanner.nextLine();
				            scanner.nextLine();
				            List<Nom> liste1 = new ArrayList<Nom>();
				            Nom nomAChercher = new Nom(nom, "0");
				            RécupérateurListCSV recuperateur1 = new RécupérateurListCSV(path1);
				            liste1=recuperateur1.récupérer();

							
							listeDeRecherche=moteur.rechercher(nomAChercher, liste1);
							System.out.println("Résultat de recherche de "+nomAChercher.getNomOriginal()+": ");
							for (IdNomScore element : listeDeRecherche) {
							    System.out.println(element.toString());
							}
				            
				            
		                    break;
		                case 2:
		                	System.out.println("Fournir le premier fichier CSV:");
				            String path2 = scanner.nextLine();
				            scanner.nextLine();
				            System.out.println("Fournir le deuxième fichier CSV:");
				            String path3 = scanner.nextLine();
				            scanner.nextLine();
				            RécupérateurListCSV recuperateur2 = new RécupérateurListCSV(path2);
				            List<Nom>liste2=recuperateur2.récupérer();
				            RécupérateurListCSV recuperateur3 = new RécupérateurListCSV(path3);
				            List<Nom>liste3=recuperateur3.récupérer();
				            List<Nom> listeDeComparaison = moteur.comparer(liste2, liste3);
				            
				    		System.out.println("Résultat de comparaison:");
				    		for (Nom element : listeDeComparaison) {
				    		    System.out.println(element.toString());
				    		}
				            
		                    break;
		                case 3:
		                	System.out.println("Fournir le fichier CSV à traiter:");
				            String path4 = scanner.nextLine();
				            scanner.nextLine();
				            RécupérateurListCSV recuperateur4 = new RécupérateurListCSV(path4);
				            List<Nom>liste4=recuperateur4.récupérer();
				            List<Nom> listeDédupliquée = moteur.dedupliquer(liste4);
				            System.out.println("Résultat de la déduplication:");
				    		for (Nom element : listeDédupliquée) {
				    		    System.out.println(element.toString());
				    		}
		                    break;
		                case 4:
		                	System.out.println("Choisir votre configuration:");
		                	System.out.println("1.choisir le prétraitement:");
		                    String nompreprocesseur= scanner.nextLine();
				            scanner.nextLine();
				            System.out.println("1.choisir une structure d'index:");
		                    String nomindex= scanner.nextLine();
				            scanner.nextLine();
				            System.out.println("1.choisir une mesure de comparaison:");
		                    String nomCompChaine= scanner.nextLine();
				            scanner.nextLine();
				            System.out.println("1.Définir un max de résultat:");
		                    int maxresult= scanner.nextInt();
				            scanner.nextLine();
				            System.out.println("1.Définir un seuil:");
		                    int seuil= scanner.nextInt();
				            scanner.nextLine();
				            Configuration config = new Configuration(nompreprocesseur, nomindex, nomCompChaine, seuil, maxresult);
		                	break;
		                case 5:
		                	System.out.println("Quitter");
		                	break;
		                default:
		                    System.out.println("Choix invalide. Réessayez.");
		            }

		            System.out.println(); // ligne vide pour l'affichage

		        } while (choix != 5);

		        scanner.close();
		    }
		


	}


