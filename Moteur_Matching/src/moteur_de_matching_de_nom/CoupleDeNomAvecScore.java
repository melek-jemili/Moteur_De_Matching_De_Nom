package moteur_de_matching_de_nom;

public record  CoupleDeNomAvecScore(Nom nom1 , Nom nom2 , double score){
	

	public CoupleDeNomAvecScore(Nom nom1 , Nom nom2 , double score) {
		// TODO Auto-generated constructor stub
		this.nom1=nom1;
		this.nom2=nom2;
		this.score=score;
	}

	public Nom getNom1() {
		return nom1;
	}

	public Nom getNom2() {
		return nom2;
	}

	public double getScore() {
		return score;
	}
	
	
	
	public String toString() {
		return "nom:"+" "+nom2.getNomOriginal()+" "+"score:"+" "+score;
	}
	

	
	@Override
	public boolean equals(Object o) {
	    if (o instanceof CoupleDeNomAvecScore) {
	    	CoupleDeNomAvecScore CoupleNomEtScore=(CoupleDeNomAvecScore) o;
	    	if (this.nom1==CoupleNomEtScore.nom1 && this.nom2==CoupleNomEtScore.nom2) {
	    		return true;
	    	}
	    }
	    return false;
	}

	@Override
	public int hashCode() {
	    return nom2.hashCode(); 
	}

}
