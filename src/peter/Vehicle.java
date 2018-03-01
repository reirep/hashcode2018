package peter;

import java.util.LinkedList;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class Vehicle {
    LinkedList<Ride> takenRide = new LinkedList<>();
    LinkedList<Integer> startRide = new LinkedList<>();

    int x = 0, y = 0;
    int nbr;
    public Vehicle(int nbr){
        this.nbr = nbr;
    }

    public int nextStepAvailable(){
        if(takenRide.size() == 0)
            return 0;
        return startRide.get(startRide.size()-1)+takenRide.get(takenRide.size()-1).sizeRide();
    }

    public String getLine(){
        String res = ""+nbr;
        for (Ride r : takenRide)
            res += ""+r.nbr;
        res+="\n";
        return res;
    }

}
