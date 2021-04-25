import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader (new FileReader (new File ("E:/андроид/t.txt")));
            reader.lines ()
                    .flatMap (x -> Arrays.stream (x.split (" ")))
                    .map (Integer::parseInt)
                    .filter (x -> x % 2 == 0)
                    .sorted ()
                    .forEach (System.out::println);
            reader.close ();
        }
    }
