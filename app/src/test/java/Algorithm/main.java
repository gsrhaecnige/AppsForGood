package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class main {

    private int[][] tops;
    private int numTops = 4;

    public static void main(String[] args) throws IOException {
        populateTopList();
    }

    private static void populateTopList(){
        for (int i = 0; i < numTops; i++){
            tops[0][i] = i + 1;
            //each top is represented by a number that correspond to the relative sleeve length
            //tank 1, t-shirt 2, long sleeve 3, sweater 4
        }

    }

}

