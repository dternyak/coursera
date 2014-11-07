import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        boolean flag = false;
        for (int j = 0; j < s.length(); j++)
        {
            char ch = s.charAt(j);
            if (ch == ' ')
            {
                aCoder = aCoder + ch;
                continue;
            }
            for (int i = 0; i < ALPHABET.length(); i++)
            {
                char c = ALPHABET.charAt(i);
                if (ch == c)
                {
                    flag = true;
                    break;
                }
            }
            if (flag)
            {
                aCoder = aCoder + ch;
            }

            flag = false;
        }

        for (int i = 0; i < aCoder.length(); i++)
        {
            char c = aCoder.charAt(i);
            if (c == ' ')
            {
                chaineCodee = chaineCodee + c;
                continue;
            } else
            {
                int index = (ALPHABET.indexOf(c) + DECALAGE) % ALPHABET.length();
                // System.out.println(c + " : "+ ALPHABET.indexOf(c) +" " + " "+ index);
                chaineCodee = chaineCodee + ALPHABET.charAt(index);
            }
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}
