package moteur_de_matching_de_nom;
import java.util.List;

public class Nom {
	
	private String nomOriginal;
	private String identifiant;
	private List<String> listDeNomPretraite;
	
	public Nom(String nomOriginal, String identifiant) {
		this.identifiant=identifiant;
		this.nomOriginal=nomOriginal;
	}
	

	public String getId() {
		return this.identifiant;
	}
	public String getNomOriginal() {
		return this.nomOriginal;
	}
	
	public List<String> getListDeNomPretraite() {
		return listDeNomPretraite;
	}


	public void setListDeNomPretraite(List<String> listDeNomPretraite) {
		this.listDeNomPretraite = listDeNomPretraite;
	}


	public String toString() {
		return "Id:"+" "+identifiant+" Nom:"+" "+nomOriginal;
	}
	
	
	@Override
	public boolean equals(Object o) {
	    if (o instanceof Nom) {
	    	Nom nom=(Nom) o;
	    	if (this.nomOriginal==nom.getNomOriginal()) {
	    		return true;
	    	}
	    }
	    return false;
	}

	@Override
	public int hashCode() {
	    return nomOriginal.hashCode(); 
	}

}
