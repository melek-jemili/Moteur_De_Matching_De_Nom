package moteur_de_matching_de_nom;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class IndexDictionnaire implements Indexeur{
		
		private Map<Integer, String> mapSelonLaTaille;
		
		public 	IndexDictionnaire(Map<Integer, String> mapSelonLaTaille) {
			this.mapSelonLaTaille= new HashMap<>();
		}
	
		public void indexer(List<String> noms) {
			        
			        
			        for (String nom : noms) {
			            mapSelonLaTaille.put(nom.length(), nom);
			        }}
		
			        
		
			        
			        
	}
		

