package Algorithm.clothing;

public class Top extends Clothing {

    private static final int numTops = 14; //need to change this value if we want to add/change the temp ranges that the shirts are applicable to
    private static int[][] tempRating = new int[2][10];
    private static int[][] tops = new int[2][numTops];

    public static void main(String[] args) {
        populateTempRating();
        populateTopList();

        /*
        int test = 101;
        System.out.println("temp rating array: "+ Arrays.deepToString(tempRating));
        System.out.println("tops array: "+ Arrays.deepToString(tops));
        System.out.println("testing whattemprange method: "+ whatTempRange(test));

        System.out.println();

        System.out.println("testing top method: " + top(test));
         */

    }

    public static String top(double feelsLike){
        int rating = whatTempRange(feelsLike);

        for (int i = 0; i < numTops; i++){
            if (rating == tops[1][i])
                return shirtType(tops[0][i]);
        }

        return null;
    }



    private static void populateTempRating(){
        for (int i = 0; i < 10; i++){
            tempRating[0][i] = -30 + 15*i;
            tempRating[1][i] = i + 1;
        }
    }

    //each top is represented by a number that sorta corresponds to the relative sleeve length
    //tank 1, t-shirt 2, long sleeve 3, sweater 4
    private static void populateTopList(){
        //populating the tank tops. current temp range is 8-9.
        for (int i = 0; i < 2; i++){
            tops[0][i] = 1;
            tops[1][i] = 9 + i;
        }

        //populating t-shirts. current temp range is 7-10.
        for (int i = 2; i < 6; i++){
            tops[0][i] = 2;
            tops[1][i] = 5 + i; //because "i" starts at 2 and we want the first value to be 7
        }

        //populating long sleeves. current temp range is 6-7.
        for (int i = 6; i < 8; i++){
            tops[0][i] = 3;
            tops[1][i] = i;
        }

        int counter = 1;
        //populating sweaters. current temp range is 1-6
        for (int i = 8; i < 14; i++){
            tops[0][i] = 4;
            tops[1][i] = counter;
            counter++;
        }

    }

    private static int whatTempRange(double temp){
        int temperature = (int)temp;

        for (int i = 0; i < 10; i++){
            if (i == 0){
                if (temperature < tempRating[0][0])
                    return tempRating[1][0];
            }

            if (i == 9){
                if (temperature > tempRating[0][i])
                    return tempRating[1][i];
            }

            if (temperature == tempRating[0][i])
                return tempRating[1][i];

            else {
                if (temperature < tempRating[0][i] && temperature > tempRating[0][i-1])
                    return tempRating[1][i];
            }
        }

        return 0;

    }

    private static String shirtType(int key){
        if (key == 1)
            return "tank top";

        if (key == 2)
            return "t-shirt";

        if (key == 3)
            return "long sleeve";

        if (key == 4)
            return "sweater";

        else
            return null;
    }

}
