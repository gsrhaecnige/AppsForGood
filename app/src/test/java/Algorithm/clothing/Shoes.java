package Algorithm.clothing;

public class Shoes extends Clothing{
    private final int numShoes = 5;

    private final int[][] shoeRec = new int[3][numShoes];

    /**
     * default constructor for the Shoe class
     */
    public Shoes(){
        super();
        populateShoe();
    }

    /**
     * this method will get the recommended shoes for the given weather
     * @param temp a double of the temperature
     * @param isSnowing boolean of if it is snowing
     * @param isRaining booleano of if it is raining
     * @return a string with the recommended footwear.
     */
    public String getShoe(double temp, boolean isRaining, boolean isSnowing){
        int range = whatTempRange(temp);

        if (isSnowing)
            return shoeType(shoeRec[0][0]);

        if (isRaining)
            return shoeType(shoeRec[0][1]);

        for (int i = 0; i < numShoes; i++){
            if (range >= shoeRec[1][i] && range <= shoeRec[2][i])
                return shoeType(shoeRec[0][i]);
        }

        return null;
    }

    /**
     * this helper method will populate the shoe array with pre-specified values
     */
    private void populateShoe(){
        for (int i = 0; i < numShoes; i++)
            shoeRec[0][i] = i + 1;

        //populating snow boot and rain boot bottom rows
        for (int i = 0; i < 2; i++){ //populates bottom two rows with -5 because these don't depend on temp
            shoeRec[1][i] = -5;
            shoeRec[2][i] = -5;
        }

        //sandals. temp range: 8-10
        shoeRec[1][2] = 8;
        shoeRec[2][2] = 10;

        //sneakers or casual shoes. temp range 3-7
        shoeRec[1][3] = 3;
        shoeRec[2][3] = 7;

        //warm boots for cold weather
        shoeRec[1][4] = 0;
        shoeRec[2][4] = 2;

    }

    /**
     * this method will take a "key" and give you the corresponding shoe type
     * @param key an int key
     * @return a string of the type of shoe
     */
    private String shoeType(int key){
        if (key == 1)
            return "Snow boots";

        if (key == 2)
            return "Rain boots";

        if (key == 3)
            return "Sandals";

        if (key == 4)
            return "Sneakers or casual shoes";

        if (key == 5)
            return "Warm boots";

        else
            return null;
    }
}