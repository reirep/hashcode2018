package peter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class pierre {
    public static void main(String ... args){
        String inFile = "a_example.in";

        Scanner s = null;
        try {
            s = new Scanner(new FileReader(inFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        int row = s.nextInt();
        int col = s.nextInt();
        int vehic = s.nextInt();
        int ride = s.nextInt();
        int bonus = s.nextInt();
        int steps = s.nextInt();



        LinkedList<Ride> rides = new LinkedList<>();
        s.nextLine();
        System.out.println(s.nextLine());



    }
}
