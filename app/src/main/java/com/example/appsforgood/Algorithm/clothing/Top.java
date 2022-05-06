package com.example.appsforgood.Algorithm.clothing;

public class Top extends Clothing{
    private static final int numTops = 14; //need to change this value if we want to add/change the temp ranges that the shirts are applicable to
    private static final int[][] tops = new int[2][numTops];

    /*
    public static void main(String[] args) throws IOException {
        populateTempRating();
        populateTopList();

        int test = 101;
        System.out.println("temp rating array: "+ Arrays.deepToString(tempRating));
        System.out.println("tops array: "+ Arrays.deepToString(tops));
        System.out.println("testing whattemprange method: "+ whatTempRange(test));

        System.out.println();

        System.out.println("testing top method: " + top(test));
    }
    */

    /**
     * default constructor for the Top class.
     */
    public Top(){
        super();
        populateTopList();
    }

    /**
     * this method will decide which Top item best fits the temperature given.
     * @param feelsLike a double of the feelsLike temperature
     * @return a String of the name of the Top item
     */
    public String getTop(double feelsLike){
        int rating = super.whatTempRange(feelsLike);

        for (int i = 0; i < numTops; i++){
            if (rating == tops[1][i])
                return shirtType(tops[0][i]);
        }

        return null;
    }

    /**
     * a helper method to fill in the array that stores the top items and their respective temperature ratings.
     * each top is represented by a number that sorta corresponds to the relative sleeve length
     * tank 1, t-shirt 2, long sleeve 3, sweater 4
     */
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


    /**
     * a helper method to "translate" the numeric version of a Top item to a String
     * @param key an int between 1 and 4 (inclusive)
     * @return a string representation of the Top item. returns null if an invalid input is given.
     */
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