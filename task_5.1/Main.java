import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();


        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        System.out.println("Оригинальный список "+names);

        Object[] st = names.toArray();
        for (Object s : st) {
            if (names.indexOf(s) != names.lastIndexOf(s)) {
                names.remove(names.lastIndexOf(s));
            }
        }

        System.out.println("Исправленный список "+names);



    }

}
