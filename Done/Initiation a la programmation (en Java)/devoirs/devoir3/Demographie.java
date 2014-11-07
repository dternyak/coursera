import java.util.Scanner;
import java.text.DecimalFormat;

public class Population {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int anneeInitiale = 2011;        // annee initiale
        double tauxCroissance = 1.2;     // taux de croissance, en %
        double populationInitiale = 7.0; // population initiale, en milliard d'humains

        double populationCourante = populationInitiale; // population mondiale pour l'annee courante
        int anneeCourante = anneeInitiale;              // annee de calcul

        System.out.println("====---- PARTIE 1 ----====");
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
       //System.out.print("Quelle année (> 2011) ? ");
        int anoFinal=0;
        //anoFinal = keyb.nextInt();
        // ===== PARTIE 1 =====
        
        while(anoFinal <= anneeInitiale){
            System.out.print("Quelle année (> 2011) ? ");
            anoFinal = keyb.nextInt();
        }
        //System.out.println("" + anoFinal);
        double endValue = populationInitiale * Math.exp((anoFinal - anneeInitiale) * (tauxCroissance/100));
        System.out.println("Population en " + anoFinal + " : " + df.format(endValue));


        // ===== PARTIE 2 =====
        System.out.println("\n====---- PARTIE 2 ----====");
        double targetPopulation =0.0;
        double x=0.0;
        while(x <= populationInitiale){
            targetPopulation = keyb.nextDouble();
            if (targetPopulation <= populationInitiale){
                System.out.print("Combien de milliards (> 7.0) ? ");
            }
            else{                
                x  = (populationInitiale) * Math.exp((2012 - anneeInitiale) * (tauxCroissance/100));
                System.out.println("Combien de milliards (> 7.0) ? Population en " + 2012 + " : " + df.format(x));
                int i = anneeInitiale+2;
                while(x < targetPopulation){
                    x  = populationInitiale * Math.exp((i - anneeInitiale) * (tauxCroissance/100));
                        System.out.println("Population en " + i + " : " + df.format(x));
                        i++;
                }
            }
        }
        
  // ===== PARTIE 3 =====
        System.out.println("\n====---- PARTIE 3 ----====");
        double x3=0.0;
        double coisas=0;
        double pi = populationInitiale;
        double ai = anneeInitiale;
        double tx = tauxCroissance;
        int i = anneeInitiale+1;
        while(x3 <= populationInitiale){
                x3  = (pi) * Math.exp((i - ai) * (tx/100));
                //System.out.println("Population en " + 2012 + " : " + df.format(x3) + " ; taux de croissance : "+tauxCroissance+"%");
                while(x3 < targetPopulation){
                    System.out.println("Population en " + (i) + " : " + df.format(x3) + " ; taux de croissance : "+tx+"%");
                     i++;
                     x3  = pi * Math.exp((i - ai) * (tx/100));
                    if((i == 2069) || (i == 2185)){
                            tx = tx/2;
                            ai = i;
                            pi = x3;
                    }else{
                        coisas ++;
                    }
                }
                System.out.println("Population en " + (i) + " : " + df.format(x3) + " ; taux de croissance : "+tx+"%");
            
        }


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
    }
}
