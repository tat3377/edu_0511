public class Main {
    public static int min(int a, int b, int c, int d) {
        int min = a;

        if (b <= a) {
            min = b;
        }
        if (c <= b) {
            min = c;
        }
        if (d<=c) {
            min=d;
        }
        return min;
    }
    public static int min(int a, int b) {
        int min = a;

        if (b <= a) {
            min = b;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}
