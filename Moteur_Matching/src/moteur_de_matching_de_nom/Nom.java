package moteur_de_matching_de_nom;

import java.util.List;

public class Nom {
	
	private String identifiant;
	private String nomOriginal;
	private List<String> listDeNomPretraite;
	
	public Nom( String identifiant , String nomOriginal) {
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
	
	@Override
	 public boolean equals(Object obj) {
        if (this == obj) return true;                    // même objet
        if (!(obj instanceof Nom)) return false;         // pas un Nom

        Nom autre = (Nom) obj;
        return this.nomOriginal!= null && this.nomOriginal.equals(autre.nomOriginal);
    }

	@Override
	public int hashCode() {
		return this.nomOriginal != null ? this.nomOriginal.hashCode() : 0;
	}
	
	public String toString() {
		return "ID:"+" "+identifiant+" "+"Nom:"+" "+nomOriginal;
	}
}
