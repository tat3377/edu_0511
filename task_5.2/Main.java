import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner (System.in);
        List<String> list = new ArrayList ();
        Map<String, String> map = new HashMap<String, String> ();
        while (true) {
            String sity = scanner.nextLine ();
            if (sity.isEmpty ()) {
                break;}
         else {
                String lastName = scanner.nextLine ();
                map.put (sity, lastName);
            }
        }

            String cityKeyboard = scanner.nextLine ();

            for (Map.Entry<String, String> pair : map.entrySet ()){

            if (pair.getKey ().equals (cityKeyboard))
                    System.out.println (pair.getValue ());
        }
    }
}
