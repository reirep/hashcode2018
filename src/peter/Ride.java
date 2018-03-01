package peter;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class Ride {
    int startX, startY, endX, endY, start, end;

    public Ride(String s){
        int [] args = Utils.toInt(s.split(" "));
        startX = args[0];
        startY = args[1];
        endX = args[2];
        endY = args[3];
        start = args[4];
        end = args[5];
    }

    public int sizeRide(){
        return Math.abs(startX-endX) + Math.abs(startY-endY);
    }

}
