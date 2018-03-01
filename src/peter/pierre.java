package peter;

import java.io.*;
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
        LinkedList<Vehicle> vehicles = new LinkedList<>();

        s.nextLine();

        for(int i = 0; i < vehic; i++)
            vehicles.add(new Vehicle(i+1));

        for(int i = 0; i < ride; i++)
            rides.add(new Ride(i+1, s.nextLine()));

        //end input

        //SOLVE HERE


        //output
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(inFile+".out"));
            for(Vehicle v : vehicles)
                bw.write(v.getLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
