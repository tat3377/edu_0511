public class Main {
    public static void main(String[] args) {
    Cat cat1 = new Cat(2,3,4);
    Cat cat2 = new Cat(4,5,6);
    Cat cat3 = new Cat(7,8,9);



        System.out.println(cat1.fight(cat2));
        System.out.println(cat1.fight(cat3));
        System.out.println(cat2.fight(cat3));
        System.out.println(cat2.fight(cat1));

    }


}


public class Cat {

    public int age;
    public int weight;
    public int strength;

    public Cat(int age,int weight,int strength) {
        this.age = age;
        this.weight = weight;
        this.strength =strength;
    }

    public boolean fight(Cat anotherCat) {
        int win = 0;

        if (this.age >= anotherCat.age) {
            win++;
        }
        else win--;
        if (this.weight >= anotherCat.weight) {
            win++;
        }
        else win--;
        if (this.strength >= anotherCat.strength) {
            win++;
        }
        else win--;
        System.out.println(win);

        if (win > 1) {
            return true;
        } else return false;
    }


    }
