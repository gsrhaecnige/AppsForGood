package Algorithm.clothing;

public class Accessories extends Clothing{

    private final int numTempAcc = 6;
    private final int numPrecipAcc = 4;
    private final int numSunAcc = 4;

    private final int[][] tempAcc = new int[3][numTempAcc]; //stores the accessories that are dependant on temperature. the two bottom rows are the temperature range
    private final int[][] precipiAcc = new int[2][numPrecipAcc]; //stores the accessories that depend on precipitation. bottom row is type of precipitation
    private final int[][] sunAcc = new int [2][numSunAcc]; //BOTTOM ROW ISN"T DECIDED. accessories that are dependant on sunlight.
    // for bottom row of sun acc: right now, what would be here is hard coded into the getAcc method. could change this, but it works for the moment.

    /**
     * default constructor for the Accessory class
     */
    public Accessories(){
        super();
        populateAcc();

    }

    /**
     * this method will give you recommendations for accessories to wear
     * @param temp a double representative of the temperature
     * @param isRaining boolean of if or if not it is raining
     * @param isSnowing boolean of if or if not it is snowing
     * @param uvIndex int representation of the UV index
     * @return a string with the names of accessories to wear
     */
    public String getAcc(double temp, boolean isRaining, boolean isSnowing, int uvIndex){ //still need to do something for the sunlight accessories
        String output = "";
        int range = super.whatTempRange(temp);
        //System.out.println("the range is: " + range);

        if (isRaining){ //finds the elements in the precip array that are for rain
            for (int i = 0; i < numPrecipAcc; i++){
                if (precipiAcc[1][i] == 500){
                    output += accType(precipiAcc[0][i]) + ", ";
                }
            }
        }

        if (isSnowing){ //finds the elements in the precip array that are for snow
            for (int i = 0; i < numPrecipAcc; i++){
                if (precipiAcc[1][i] == 600){
                    output += accType(precipiAcc[0][i]) + ", ";
                }
            }
        }

        //for the sun accessories. this stuff should probably be in the sunAcc array
        if (uvIndex >= 3 && uvIndex <= 7){ //sunscreen
            output += accType(sunAcc[0][2]) + ", ";
        }

        if (uvIndex >= 8){
            for (int i = 0; i < numSunAcc; i++){
                if (i == 2)
                    output += accType(sunAcc[0][i]) + ", ";

                else
                    output += accType(sunAcc[0][i]) + ", ";
            }
        }

        for (int i = 0; i < numTempAcc; i++){ //finds elements in temp array that the temp is in the range of
            if (isRaining || isSnowing){
                if (tempAcc[0][i] == 5)
                    i ++;
                if (tempAcc[0][i] == 6)
                    return output;
            }

            if (range >= tempAcc[1][i] && range <= tempAcc[2][i]){
                output += accType(tempAcc[0][i]) + ", ";
            }
        }

        return output;
    }

    /**
     * this helper method will populate the accessory arrays
     */
    private void populateAcc(){
        //tempAccessories
        for (int i = 0; i < numTempAcc; i++){ //populating the first row
            tempAcc[0][i] = i + 1;
        }

        for (int i = 0; i < 4; i++){ //winter accessories
            tempAcc[1][i] = 1;
            tempAcc[2][i] = 5;
        }

        for (int i = 4; i < numTempAcc; i++){ //fall or spring accessories
            tempAcc[1][i] = 6;
            tempAcc[2][i] = 8;
        }


        //precipiAcc
        for (int i = 0; i < numPrecipAcc; i++){ //populating first row
            precipiAcc[0][i] = numTempAcc + 1 + i;
        }

        for (int i = 0; i < 3; i++){ //rain accessories
            precipiAcc[1][i] = 500;
        }

        for (int i = 3; i < numPrecipAcc; i++){ //snow accessories
            precipiAcc[1][i] = 600;
        }


        //sunAcc
        for (int i = 0; i < numSunAcc; i++){ //populating first row
            sunAcc[0][i] = (numTempAcc + numPrecipAcc) + 1 + i;
        }
    }

    /**
     * this method will give you the corresponding accessory for a specified key
     * @param key int representative of an accessory
     * @return the String of the accessory names
     */
    private String accType(int key){ //keys are in order: tempAcc are first, then precipAcc and then sunlight
        //temp dependant accessories
        if (key == 1)
            return "Hat or Earmuffs";

        if (key == 2)
            return "Mittens or Gloves";

        if (key == 3)
            return "Scarf";

        if (key == 4)
            return "Parka";

        if (key == 5)
            return "Vest";

        if (key == 6)
            return "Light jacket";

        //precipitation dependant accessories
        if (key == 7)
            return "Rain jacket";

        if (key == 8)
            return "Rain boots with socks";

        if (key == 9)
            return "Umbrella";

        if (key == 10)
            return "Snow Boots and Socks";

        //sunlight accessories
        if (key == 11)
            return "Sunglasses";

        if (key == 12)
            return "Sunhat";

        if (key == 13)
            return "Sunscreen";

        if (key == 14)
            return "Parasol";


        else
            return null;

    }
}