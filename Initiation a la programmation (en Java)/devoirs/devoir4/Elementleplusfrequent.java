class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        int count[] = new int[1000];// all with zero
        int numbers[][] = new int[1000][2];
        int numbersTemp[][] = new int[1000][2];
        
        int num = 0, times = 0;
        
        for (int i = 0; i < tab1.length; i++){
            numbers[i][0] = tab1[i];
            numbers[i][1] = 0;
            numbersTemp[i][0] = tab1[i];
            numbersTemp[i][1] = 0;
        }
        for (int i = 0; i < tab1.length; i++){
            int n = tab1[i];
            int coun = 0;
            for(int j =0; j <numbersTemp.length;j++){
                if(numbersTemp[j][0] == n){
                    coun++;
                }
            }
            for(int j =0; j <numbersTemp.length;j++){
                if(numbersTemp[j][0] == n){
                    numbers[j][1] = coun;
                }
            }
        }
        
        
    
        
        
        int number =0,  nTimes=0;
        int tempMax = 0;
        for (int j = 0; j < numbersTemp.length; j++){
            if (numbers[j][1]>tempMax){
                number= numbers[j][0];
                nTimes = numbers[j][1];
                tempMax = numbers[j][1];
            }
        }
        
        
        
        
        System.out.println("Le nombre le plus frequent dans le tableau est le : ");
        System.out.println(number + " (" + nTimes + " x)");

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
