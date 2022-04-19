package Algorithm.clothing;

public class Clothing {

    private static final int[][] tempRating = new int[2][10];

    /**
     * default constructor for the Clothing class
     */
    public Clothing(){
        populateTempRating();
    }

    /**
     * this helper method populates the tempRating array with preset values
     */
    private static void populateTempRating(){
        for (int i = 0; i < 10; i++){
            tempRating[0][i] = -30 + 15*i;
            tempRating[1][i] = i + 1;
        }
    }

    /**
     * this method tells you what range number corresponds to the given temperature
     * @param temp a double of the temperature
     * @return an int between 1 and 11 (inclusive)
     */
    public int whatTempRange(double temp){
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

}

