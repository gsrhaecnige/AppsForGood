package Algorithm.clothing;

public class Accessories extends Clothing {

    public String weathertype;

    //Base constructor
    public Accessories(){
        super();
        piecetype = "accesory";
        weathertype = "";
    }


    //Returns the string weathertype
    public String getWeathertype(){
        return weathertype;
    }

    //Sets the bottom length
    public void setWeathertype(String n) {
        weathertype = n;
    }

}
