package peter;

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

        s.nextLine();

        for(int i = 0; i < nbs.length; i++){
            for(int j = 0; j < nbs[i]; j++){
                rep[i][j] = s.nextLine();
            }
        }
        return rep;
    }

    public static int [] toIntSingle(String [] s){
        int [] res = new int[s.length];
        for(int i = 0; i < s.length; i++){
            res[i] = Integer.parseInt(s[i]);
        }
        return res;
    }

    public static int [][] toIntDouble(String s[], char delim){
        int [][] res = new int[s.length][];
        for(int i = 0; i < s.length; i++){
            res[i] = new int[2];
            res[i][0] = Integer.parseInt(s[i].split(""+delim)[0]);
            res[i][1] = Integer.parseInt(s[i].split(""+delim)[1]);
        }
        return res;
    }

    public static int [][] toIntTriple(String s[], char delim){
        int [][] res = new int[s.length][];
        for(int i = 0; i < s.length; i++){
            res[i] = new int[3];
            res[i][0] = Integer.parseInt(s[i].split(""+delim)[0]);
            res[i][1] = Integer.parseInt(s[i].split(""+delim)[1]);
            res[i][2] = Integer.parseInt(s[i].split(""+delim)[2]);
        }
        return res;
    }

    public static int [] toInt(String [] in){
        int [] res = new int[in.length];
        for(int i = 0; i < in.length; i++)
            res[i] = Integer.parseInt(in[i]);
        return res;
    }
}
