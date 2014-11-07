import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Decharge
{
	private static DecimalFormat df = new DecimalFormat("#.000");

	/*******************************************
	 * Completez le programme a partir d'ici.
	 *******************************************/
	public static double calculerDistance(int x1, int y1, int x2, int y2)
	{
		double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		return distance;
	}

	public static int plusProche(int x, int y, int[] coordonneesHabitations)
	{
		int xx = 0, yy = 0;
		double distance = 9999999.0;
		int position = 0;
		double distTemp = 0.0;
		for (int i = 0; i < coordonneesHabitations.length/2; i ++)
		{
			xx = coordonneesHabitations[i*2];
			yy = coordonneesHabitations[i*2 + 1];
			// System.out.println(xx + "-"+ yy);
			distTemp = calculerDistance(x, y, xx, yy);
			if (distTemp < distance)
			{
				distance = distTemp;
				position = i;
				//System.out.println(i);
			}
		}
		//System.out.println(position);
		return position;
	}

	public static int[] troisPlusProches(int x, int y, int[] coordonneesHabitations)
	{
		int[] three = new int[6];
		int[] tmp = new int[coordonneesHabitations.length];
		System.arraycopy(coordonneesHabitations, 0, tmp, 0, coordonneesHabitations.length);

		int index = 0;
		for (int i = 0; i < three.length/2; i++)
		{
			index = plusProche(x, y, tmp);
			tmp[index * 2] = 999;
			tmp[index * 2 + 1] = 999;
			//System.out.println("mais proxima: "+index);
			//System.out.println(coordonneesHabitations[index * 2] + " "+ coordonneesHabitations[index * 2+1]);
			three[i*2] = coordonneesHabitations[index * 2];
			three[i*2+1] = coordonneesHabitations[index * 2+1];
		}
		
		return three;
	}

	public static int[] meilleurePlace(int x, int y, int[] coordonneesHabitations)
	{
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
		int x1 = tpp[0];
		int y1 = tpp[1];
		int x2 = tpp[2];
		int y2 = tpp[3];
		int x3 = tpp[4];
		int y3 = tpp[5];
		
		double cx = (int)(x1 + x2 + x3) / 3;
		double cy = (int)(y1 + y2 + y3) / 3;
		
		int[] best = {(int)cx, (int)cy};
		return best;
	}

	/*******************************************
	 * Ne rien modifier apres cette ligne.
	 *******************************************/

	public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations)
	{
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);

		System.out.println("(" + x + "," + y + ") est a :");
		for (int i = 0; i < 3; i++)
		{
			System.out.println("    " + df.format(calculerDistance(x, y, tpp[2 * i], tpp[2 * i + 1])) + " de (" + tpp[2 * i] + "," + tpp[2 * i + 1]
					+ ")");
		}
	}

	// PROGRAMME PRINCIPAL
	public static void main(String args[])
	{

		int[] coordonneesHabitations =
		{ 9, 30, 18, 8, 3, 18, 25, 36 };

		// Lecture des donnees
		Scanner clavier = new Scanner(System.in);
		System.out.print("Entrez la coordonnee x de la decharge: ");
		int x = clavier.nextInt();
		System.out.print("Entrez le coordonnee y de la decharge: ");
		int y = clavier.nextInt();

		// trouve les coordonnees de l'habitation la plus proche
		// (identifiees par l'indice correspondant dans le tableau
		// de coordonnees)
		int plusProche = plusProche(x, y, coordonneesHabitations);
		System.out.println("--- Question 1 ---");
		System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
		System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = "
				+ df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))
				+ " metres");

		// trouve les coordonnees des 3 habitations les plus proches et affiche les coordonnees

		System.out.println("--- Question 2 ---");
		System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
		afficheTroisPlusProches(x, y, coordonneesHabitations);

		// affiche le centre de gravite des 3 plus proches (la meilleure place)
		int[] grav = meilleurePlace(x, y, coordonneesHabitations);
		System.out.println("--- Question 3 ---");
		System.out.println("Coordonnees de la meilleure place pour la decharge :");
		System.out.println("(" + grav[0] + "," + grav[1] + ")");
		clavier.close();
	}

}
