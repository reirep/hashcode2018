package peter;

import java.util.LinkedList;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class Vehicle {
    LinkedList<Ride> takenRide = new LinkedList<>();
    LinkedList<Integer> startRide = new LinkedList<>();

    int x = 0, y = 0;
    public Vehicle(){

    }

    public int nextStepAvailable(){
        if(takenRide.size() == 0)
            return 0;
        return startRide.get(startRide.size()-1)+takenRide.get(takenRide.size()-1).sizeRide();
    }

}
