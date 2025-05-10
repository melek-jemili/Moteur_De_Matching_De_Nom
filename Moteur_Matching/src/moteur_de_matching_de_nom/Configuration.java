package moteur_de_matching_de_nom;

public class Configuration {
	
	private String nomProcesseur;
	private String nomIndex;
	private String nomCompchaine;
	private double seuil;
	private int maxResult;
	
	public Configuration(String nomProcesseur,String nomIndex ,String nomCompchaine, double seuil , int maxResult) {
		this.nomProcesseur=nomProcesseur;
		this.nomIndex=nomIndex;
		this.maxResult=maxResult;
		this.nomCompchaine=nomCompchaine;
		this.seuil=seuil;
	}

	public String getNomProcesseur() {
		return nomProcesseur;
	}

	public void setNomProcesseur(String nomProcesseur) {
		this.nomProcesseur = nomProcesseur;
	}

	public String getNomIndex() {
		return nomIndex;
	}

	public void setNomIndex(String nomIndex) {
		this.nomIndex = nomIndex;
	}

	public String getNomCompchaine() {
		return nomCompchaine;
	}

	public void setNomCompchaine(String nomCompchaine) {
		this.nomCompchaine = nomCompchaine;
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

}