import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by the awesome pierre on 1/03/18
 */
public class Utils {
    public static String [][] parse(String file, int [] nbs) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(file));
        String rep [][] = new String[nbs.length][];
        for(int i = 0; i < nbs.length; i++){
            for(int j = 0; j < nbs[i]; j++){
                rep[i][j] = s.nextLine();
            }
        }
        return rep;
    }
}
