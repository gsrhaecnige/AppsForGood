package Algorithm.clothing;

public class Top extends Clothing {

    public int sleevelength;

    //Base constructor
    public Top(){
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
