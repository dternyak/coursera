import java.util.Scanner;

class PredProie{
	
	private final static double TAUX_ATTAQUE_INIT = 0.01;
	private final static double TAUX_CROISSANCE_LAPINS = 0.3;
	private final static double TAUX_CROISSANCE_RENARDS = 0.008;
	private final static double TAUX_MORTALITE = 0.1;
	private final static int DUREE = 50;
	
	public static void afficheStatus(int temps, double lapins, double renards)
	{
		System.out.print("Apres ");
		System.out.print(temps);
		System.out.print(" mois, il y a ");
		System.out.format("%.3f", lapins );
		System.out.print(" lapins et ");
		System.out.format("%.3f", renards );
		System.out.println(" renards");
	}
	
	public static void afficheTauxDAttaque(double tauxAttaque)
	{
		System.out.println("");
		System.out.print("***** Le taux d'attaque vaut ");
		System.out.format("%.2f", tauxAttaque * 100);
		System.out.println("%");
	}
	
	/*****************************************************
	 * Compléter le code à partir d'ici
	 *****************************************************/


	public static double entrerPopulation(String animal, double nombreMin, Scanner clavier) {
            // A COMPLETER
		    // completer en utilisant cette ligne sans la modifier
			System.out.print("Combien de " + animal +  "  au depart (>=" + nombreMin + ") ? ");
			
			// A modifier pour un retour correct:
			return 0;
			
	}
		
	public static void afficheResultat(String animal, boolean menacesExtinction, boolean disparus, boolean remonte) {
		
	}
	
	public static double calculerLapins(double lapins, double renards, double tauxAttaque) {
		// A COMPLETER
		
		// A modifier pour un retour correct: 
		return 0;	
	}
	
	public static double calculerRenards(double lapins, double renards, double tauxAttaque) {
		// A COMPLETER
		
		// A modifier pour un retour correct: 
		return 0;
	}
	
	public static void simule(double renardsInit, double lapinsInit, double tauxInit, double tauxFin)	{
		// A COMPLETER
	}
	
	
	/*******************************************
	 * ne rien modifier apres cette ligne
	 *******************************************/
	
	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		
		// Saisie des populations initiales
		double renardInit = entrerPopulation("renards", 2.0, clavier);
		double lapinsInit = entrerPopulation("lapins", 5.0, clavier);
		
		// ===== PARTIE 1 =====
		// Première simulation
		// Evolution de la population avec les paramètres initiaux

		simule(renardInit, lapinsInit, TAUX_ATTAQUE_INIT, TAUX_ATTAQUE_INIT);
	
		// ===== PARTIE 2 =====
		// Variation du taux d'attaque
		System.out.println("");
	
		double tauxInit = 0.0;
		double tauxFin = 0.0;
	
		do {
			System.out.print("taux d'attaque au depart en % (entre 0.5 et 6) ? ");
			tauxInit = clavier.nextDouble();
		} while ((tauxInit < 0.5) || (tauxInit > 6.0));
	
		do {
			System.out.print("taux d'attaque a la fin  en % (entre ");
			System.out.print(tauxInit);
			System.out.print(" et 6) ? ");
			tauxFin = clavier.nextDouble();
		} while ((tauxFin < tauxInit) || (tauxFin > 6.0));
	
		tauxInit /= 100.0;
		tauxFin  /= 100.0;
		
	
		simule(renardInit, lapinsInit, tauxInit, tauxFin);
	}
}
