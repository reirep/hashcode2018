package peter;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class pierre {

    public static int jump = 0;

    public static class Point {

        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == x && p.y == y;
        }
    }


    public static void main(String ... args){
        String inFile = "d_metropolis.in";

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

        ArrayList<Ride> rideGrid [][]= new ArrayList[row][col];




        LinkedList<Ride> rides = new LinkedList<>();
        LinkedList<Vehicle> vehicles = new LinkedList<>();

        s.nextLine();

        for(int i = 0; i < vehic; i++)
            vehicles.add(new Vehicle(i+1));

        for(int i = 0; i < ride; i++)
            rides.add(new Ride(i, s.nextLine()));

        //end input

        // on remplis la matrice avec les ride
        System.out.println("Started pre");
        for (int i=0; i< ride; i++) {

            Ride temp=rides.get(i);
            if(rideGrid[temp.startX][temp.startY] == null)
                rideGrid[temp.startX][temp.startY] = new ArrayList<>();
            rideGrid[temp.startX][temp.startY].add(temp);

        }
        System.out.println("Ended pre");
        out: for(int currentStep=0; currentStep< steps; currentStep++) {
            for ( int i=0; i< vehic; i++){
                System.out.print("\r"+ride);
                if(ride == 0)
                    break out;

                Vehicle currentVehic= vehicles.get(i);

                if (currentStep == currentVehic.nextStepAvailable()) {
                    Ride bestRide= null;
                    ArrayList<Ride> possibleRide = null;
                    if(rideGrid[currentVehic.x][currentVehic.y] != null){
                        possibleRide = rideGrid[currentVehic.x][currentVehic.y];
                    }
                    bestRide = getBestRide(possibleRide, currentStep);

                    if (bestRide==null){// on cherche recursivement dans les voisins
                        jump = 0;
                        Point point=bfs(new Point(currentVehic.x,currentVehic.y),rideGrid);
                        if (point != null) {
                            bestRide = getBestRide(rideGrid[point.x][point.y], currentStep);
                            possibleRide = rideGrid[point.x][point.y];
                        }
                    }

                    if (bestRide!= null) {
                        ride--;
                        possibleRide.remove(bestRide);

                        currentVehic.takenRide.add(bestRide);
                        currentVehic.startRide.add(currentStep);

                        currentVehic.x = bestRide.endX;
                        currentVehic.y = bestRide.endY;
                    }

                }
            }
        }


        //SOLVE HERE


        //output
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(inFile+".out"));
            for(Vehicle v : vehicles)
                bw.write(v.getLine());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Point> adj(ArrayList<Ride>[][]grid  , int x, int y){

        ArrayList<Point> neighbor =new ArrayList<>();
        if(x-1>=0) {
            neighbor.add(new Point(x-1,y));
        }
        if (x+1<4000) {
            neighbor.add(new Point(x+1,y));
        }
        if(y-1>=0) {
            neighbor.add(new Point(x,y-1));
        }
        if (y+1<4000) {
            neighbor.add(new Point(x,y+1));
        }
        return  neighbor;
    }
    private static  Point bfs(Point s,  ArrayList<Ride>[][] grid  ){
        if(jump > 50)
            return null;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] marked=new boolean[grid.length][grid[0].length];
        queue.add(s); // and put it on the queue.
        marked[s.x][s.y]=true;

        while (!queue.isEmpty())
        {
            Point v = queue.poll(); // Remove next vertex from the queue.

            for (Point w : adj(grid,v.x,v.y)) {
                if(!marked[w.x][w.y]) {
                    if(grid[w.x][w.y] != null)
                        if (grid[w.x][w.y].size() > 0) return w;
                    queue.add(w);
                    marked[w.x][w.y]=true;
                }
            }
        }
        return null;
    }

    public  static Ride getBestRide(ArrayList<Ride> rides, int currentStep){
        if(rides == null || rides.size()<1)
            return null;

        Ride bestRide= rides.get(0);
        for (int i=1; i<rides.size();i++){

            Ride currentRide =rides.get(i);
            if(bestRide.start > currentRide.start)
                bestRide=currentRide;

            if(bestRide.sizeRide()< currentRide.sizeRide())
                bestRide= currentRide;

        }
        return  bestRide;
    }


}
