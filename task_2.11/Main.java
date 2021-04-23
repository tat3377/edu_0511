public class Main {

    public static void main(String[] args) throws Exception {
      int[]numbers = {2,7,4,5,6};
      int sum=0;

     for (int i = 0; i< numbers.length; i++) {
         sum += numbers[i];

        if (sum >= 10)
        System.out.println("C начала массива для получения в сумме больше 10 надо сложить" + (i-1) +  "числа");

    }
}}
