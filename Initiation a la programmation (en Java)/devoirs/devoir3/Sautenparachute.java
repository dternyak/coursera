import java.util.Scanner;

class Parachutiste {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextInt();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
double gravity = 9.81;
    double parachute = 2.0;
    double s = parachute / masse;
    double v0 = 0;
    double vitesse = 0;
    double hauteur = h0;
    double accel = gravity;
    int t1 = 0;
    int t0 = 0;
    int cenas = 0;
    int c = 0;
    int p = 0;
    while (hauteur > 0.00000)
    {
      double q = Math.exp(-s * (t1 - t0));
      hauteur = (h0 - ((gravity / s) * (t1 - t0)) - (((v0 - (gravity / s)) / s) * (1 - q)));
      vitesse = (((gravity / s) * (1 - q)) + (v0 * q));
      if (vitesse > 343)
      {
        if (c == 0)
        {
          System.out.println("## Felix depasse la vitesse du son");
          c += 1;
        }
      }
      accel = gravity - (s * vitesse);
      
      if (accel < 0.5 && cenas == 0)
      {
        System.out.println("## Felix a atteint sa vitesse maximale");
        cenas += 1;
      }
      
      // Utilisez cette ligne pour l'affichage
      if ((hauteur < 2500 && p == 0) && t1 != 0)
      {
        System.out.println("## Felix ouvre son parachute");
        p += 1;
        parachute = 25.0;
        s = parachute / masse;
        h0 = hauteur;
        t0 = t1;
        v0 = vitesse;
      }
      if (hauteur > 0)
      {
        System.out.print(t1 + ", ");
        System.out.format("%.4f, ", hauteur);
        System.out.format("%.4f, ", vitesse);
        System.out.format("%.5f\n", accel);
      }
      t1 += 1;
      /*******************************************
       * Ne rien modifier apres cette ligne.
       *******************************************/

    }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
