import java.util.Scanner;

class Cluedo2
{

	private static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {

        System.out.print("Pensez a un personnage : Mlle Rose, ");
        System.out.println("le Professeur Violet, le Colonel Moutarde,");
        System.out.println("le Reverend Olive ou Mme Leblanc.\n");
        
        
        System.out.print("Est-ce que votre personnage est un homme ? ");
        System.out.print("(true : oui, false : non) ");
        boolean homme = clavier.nextBoolean();

        if (homme){
        	System.out.print("Votre personnage a-t-il des moustaches ? ");
                boolean moustaches = clavier.nextBoolean();
                if (moustaches){
                	System.out.print("==> Le personnage auquel vous pensez est ");
                	System.out.print("le Colonel Moutarde");
                }else{
                	System.out.print("Votre personnage porte-t-il un chapeau ? ");
                	boolean chapeau = clavier.nextBoolean();
                	if (chapeau) { 
                		System.out.print("==> Le personnage auquel vous pensez est ");
                        	System.out.print("le Professeur Violet");
                	}else{
                		System.out.print("==> Le personnage auquel vous pensez est ");
                		System.out.print("le Reverend Olive");
                	}
                }
        }else{
        	System.out.print("Votre personnage porte-t-il des lunettes ? ");
                boolean lunettes = clavier.nextBoolean();
                if(!lunettes){
                	System.out.print("==> Le personnage auquel vous pensez est ");
                	System.out.print("Mlle Rose");
                }else{
                	System.out.print("==> Le personnage auquel vous pensez est ");
                	System.out.print("Mme Leblanc");
                }
        }
        
        

       // System.out.print("Votre personnage porte-t-il un chapeau ? ");
        //boolean chapeau = clavier.nextBoolean();

        

        
        
     
        System.out.println();
    }
}
