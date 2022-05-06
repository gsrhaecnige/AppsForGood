package com.example.appsforgood.Algorithm.clothing;

public class Bottom extends Clothing {

    private static int numBottoms = 10; //change depending on number of options
    private static int[][] bottoms = new int[2][numBottoms];

    /**
     * the default constructor for the Bottom class.
     */
    public Bottom(){
        super();
        populateBottoms();
    }

    /**
     * this method will decide which Bottom item best fits the temperature given.
     * @param temp a double "temperature"
     * @return a String representation of the Bottom item.
     */
    public String getBottoms(double temp){

        int rating = super.whatTempRange(temp);

        for (int i = 0; i < numBottoms; i++){
            if(rating == bottoms[1][i])
                return bottomType(bottoms[0][i]);
        }

        return null;
    }

    /**
     * a helper method to fill in the array that stores the Bottom items and their respective temperature ratings.
     * each Bottom is represented by a number
     * shorts 1, long pants 2
     */
    private void populateBottoms(){
        //shorts: 1, range 8-10
        for(int i = 0; i < 3; i++){
            bottoms[0][i] = 1;
            bottoms[1][i] = 8 + i;
        }

        int count = 1;
        //long pants: 2, range 1-7
        for (int i = 3; i < numBottoms; i++){
            bottoms[0][i] = 2;
            bottoms[1][i] = count;
            count++;
        }
    }

    /**
     * a helper method to "translate" the numeric version of a Bottom item to a String
     * @param key an int between 1 and 2 (inclusive)
     * @return a string representation of the Bottom item. returns null if an invalid input is given.
     */
    private String bottomType(int key){
        if (key == 1)
            return "shorts";

        if (key == 2)
            return "long pants";

        else
            return null;
    }

}
