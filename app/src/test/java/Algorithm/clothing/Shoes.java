package Algorithm.clothing;

public class Shoes extends Clothing {

    public String weathertype;

    //Base constructor
    public Shoes(){
        super();
        piecetype = "shoe";
        weathertype = "";
    }


    //Returns the int sleevelength
    public String getWeathertype(){
        return weathertype;
    }

    //Sets the sleeve length
    public void setWeathertype(String n) {
        weathertype = n;
    }
}
