public class Main {
    public static int min(int a, int b, int c) {
        int min = a;

        if (b <= a) {
            min = b;
        }
        if (c <= b) {
            min = c;
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
