import java.text.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.File;
import java.io.IOException;

class RandomNumbers{

    static int lowestNumber(int[] RandomArray){
    int low = RandomArray[0];
        for(int i=0;i<RandomArray.length;i++){
            if(RandomArray[i] < low){
                low = RandomArray[i];
            }
        }

        return low;
    }
    public static void main (String[] args) throws java.lang.Exception{
            Random r = new Random();
            int[] RandomArray =new int[500];
        for(int i=0;i<RandomArray.length; i++) {
            RandomArray[i] = r.nextInt(1000);
        }
 /*      for(int i=0;i<RandomArray.length; i++){ //Prints out all the generated numbers
           System.out.print(RandomArray[i]);
      }
        System.out.println(" ");
        */
        System.out.println(lowestNumber(RandomArray));
    }
}