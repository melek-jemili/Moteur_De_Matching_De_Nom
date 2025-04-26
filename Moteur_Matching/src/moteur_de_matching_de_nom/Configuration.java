package moteur_de_matching_de_nom;

public class Configuration {
	
	Preprocesseur p;
	Indexeur ind;
	Comparateur_chaine comp_ch;
	double seuil;
	int maxResult;
	
	public Configuration(Preprocesseur p, Indexeur ind, Comparateur_chaine comp_ch, double seuil , int maxResult) {
		this.comp_ch=comp_ch;
		this.ind=ind;
		this.maxResult=maxResult;
		this.p=p;
		this.seuil=seuil;
	}

	public Preprocesseur getP() {
		return p;
	}

	public void setP(Preprocesseur p) {
		this.p = p;
	}

	public Indexeur getInd() {
		return ind;
	}

	public void setInd(Indexeur ind) {
		this.ind = ind;
	}

	public Comparateur_chaine getComp_ch() {
		return comp_ch;
	}

	public void setComp_ch(Comparateur_chaine comp_ch) {
		this.comp_ch = comp_ch;
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
