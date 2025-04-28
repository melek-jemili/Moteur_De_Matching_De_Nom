package moteur_de_matching_de_nom;


public class ProgrammePrincipal {

	public static void main(String[] args) {
		JaroWinkler obj1 = new JaroWinkler();
		Levenshtein obj2 = new Levenshtein();
		Egalite obj3 = new Egalite();

		String n = "melek";
		String m = "malek";
		
		double a=obj1.comparer(n, m);
		System.out.println("valeur 1 : "+a);
		double b=obj2.comparer(n, m);
		System.out.println("valeur 1 : "+b);
		double c=obj3.comparer(n, m);
		System.out.println("valeur 1 : "+c);
		
		
		
		
		
	}

}
