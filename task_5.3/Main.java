import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList (11);
        ArrayList<String> list2 = new ArrayList (11);
        list1.add ("0");
        list1.add ("1");
        list1.add ("2");
        list1.add ("3");
        list1.add ("4");
        list1.add ("5");
        list1.add ("6");
        list1.add ("7");
        list1.add ("8");
        list1.add ("9");
        list1.add ("10");
        System.out.println (list1);
        list2= list1;
        list2.remove("0");
        list2.remove("10");
        System.out.println (list2);


    }
}
