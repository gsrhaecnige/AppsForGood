package Algorithm.clothing;

public class Bottom extends Clothing {

    public int bottomlength;

    //Base constructor
    public Bottom(){
        super();
        piecetype = "top";
        bottomlength = 1;
    }




    //Returns the int bottomlength
    public int getBottomlength(){
        return bottomlength;
    }

    //Sets the bottom length
    public void setBottomlength(int n) {
        bottomlength = n;
    }

}
