public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int vklad = scan.nextInt();
        int procent = scan.nextInt();


        for (int j = 1; j < 6; j++){
        int rost = ((vklad*procent)*j)/100;
             int result = rost +vklad;
             if(vklad>0 && procent<100 && procent>0){
                 System.out.println(j +"год- "+ "Прибыль:"+rost+" Доход:"+result);
             }

    }
}}
