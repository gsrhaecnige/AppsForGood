package Algorithm.clothing.toppieces;

import Algorithm.clothing.Top;

public class Shirt extends Top {

    //Base constructor
    public Shirt(){
        super();
        piecetype = "top";
        sleevelength = 1;
    }




    //Returns the int sleevelength
    public int getSleevelength(){
        return sleevelength;
    }

    //Sets the sleeve length
    public void setSleevelength(int n) {
        sleevelength = n;
    }

}
