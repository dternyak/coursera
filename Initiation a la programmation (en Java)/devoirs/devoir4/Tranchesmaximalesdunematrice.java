import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);

        // stocke les indices des lignes contenant la plus grande sequence de
        // '1' consecutifs dans la matrice
        ArrayList<Integer> maxConsecutifList = new ArrayList<Integer>();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        boolean flag = true, flag2 = false, flag3 = true;
        String[] lignes2 = matrice.split(" {1,}");
        ArrayList<String> lignes = new ArrayList<String>();

        int j = 0;
        for (int i = 0; i < lignes2.length; i++)
        {
            String ss = lignes2[i].trim();
            // System.out.println(ss + " " + ss.equals(""));
            if (!ss.equals(""))
            {
                lignes.add(lignes2[i].trim());
            }
        }
        int count = 0;
        if (!lignes.isEmpty())
        {
            count = lignes.get(0).length();
        }
        // System.out.println("count: " + count);
        else
        {
            if (lignes.size() < 2)
            {
                System.out.println("Matrice vide!");
                return;
            }else{
                flag3 = true;
            }
        }

        if (flag3)
        {
            for (String s : lignes)
            {
                // System.out.println("s: " + s);
                for (int i = 0; i < s.length(); i++)
                {
                    // int n = Integer.parseInt(s.charAt(i) + "");
                    if (!(s.charAt(i) == '0' || s.charAt(i) == '1'))
                    {
                        System.out.println("Matrice invalide, seulement '1' , '0' et ' ' admis!");
                        return;
                    }
                }
                if (flag2)
                {
                    break;
                }
            }

            if (!flag2)
            {
                for (String s : lignes)
                {
                    if (s.length() != count)
                    {
                        System.out.println("Matrice invalide, lignes de longueurs differentes!");
                        return;
                    }
                }
            }
            int max = 0, cnt = 0;
            if (flag && !flag2)
            {
                int sum = 0;
                for (String s : lignes)
                {
                    cnt = 0;
                    for (int i = 0; i < s.length(); i++)
                    {
                        cnt = 0;
                        while (i < s.length() && s.charAt(i) == '1')
                        {
                            cnt++;
                            i++;
                        }
                        if (cnt > max)
                        {
                            max = cnt;
                        }
                        // System.out.println(s + " " + max);
                    }

                }

                if (max > 0)
                {
                    // now
                    int maxi = max;
                    int row = 0;
                    for (String s : lignes)
                    {

                        cnt = 0;
                        max = 0;
                        for (int i = 0; i < s.length(); i++)
                        {
                            cnt = 0;
                            while (i < s.length() && s.charAt(i) == '1')
                            {
                                cnt++;
                                i++;
                            }
                            if (cnt > max)
                            {
                                max = cnt;
                            }

                        }
                        // System.out.println(s + " " + max);
                        if (max == maxi)
                        {
                            maxConsecutifList.add(row);
                        }
                        row++;
                    }
                }
            }
        }


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1!");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs:");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }
}
