package Algorithm.clothing;

public class Clothing {

    public String name;
    public String piecetype;
    public int mintemp;
    public int maxtemp;



    //Base constructor
    public Clothing(){
        name = "";
        piecetype = "";
        mintemp = 0;
        maxtemp = 0;
    }

    //Returns the String name
    public String getName(){
        return name;
    }

    //Returns the int Mintemp
    public int getMintemp(){
        return mintemp;
    }

    //Returns the int Maxtemp
    public int getMaxtemp(){
        return maxtemp;
    }

    //Set clothing name
    public void setName(String n) {
        name = n;
    }

    //Set outfit piece type
    public void setPiecetype(String n) {
        piecetype = n;
    }

    //Set clothing minimum temperature
    public void setMintemp(int n) {
        mintemp = n;
    }

    //Set clothing maximum temperature
    public void setMaxtemp(int n) {
        maxtemp = n;
    }

}

