public class Main {
    public static void main(String[] args){
        UssuriTiger fire = new  UssuriTiger ("Огонь", "Уссурийский тигр", 5, "Полосатый","мясо","Приморский край", 300 );
        Horse rysak = new Horse("Рысак","Орловская", 3,"Чёрный","овёс","Россия", 80);
        fire.name();
        fire.breed();
        fire.age();
        fire.color();
        fire.nutrition();
        fire.habitat();
        fire.weight();
        fire.roar();


        rysak.name();
        rysak.breed();
        rysak.age();
        rysak.color();
        rysak.nutrition();
        rysak.habitat();
        rysak.speed();
        rysak.run();



    }
}


public abstract class Animal {
    String name;
    String breed;
    int age;
    String color;
    String nutrition;
    String habitat;

    public Animal(String name, String breed, int age, String color, String nutrition, String habitat) {
        this.name=name;
        this.breed=breed;
        this.age=age;
        this.color=color;
        this.nutrition=nutrition;
        this.habitat=habitat;
    }

    String getName() {
        return this.name;
    }
    String getBreed() {return this.breed;}
    int getAge () { return this.age;}
    String getColor () { return this.color;}
    String getNutrition () { return this.habitat;}

    void name (){
        System.out.println("Кличка животного: "+ this.name);}

        void breed (){
            System.out.println("Порода: "+ this.breed);}

    void age (){
        System.out.println("Возраст животного "+ this.age+" лет/года");}

    void color (){
        System.out.println("Окрас животного: " + this.color);}

    void nutrition (){
        System.out.println("Животное употребляет в пищу "+ this.nutrition);}

    void habitat (){
        System.out.println("Среда обитания: "+ this.habitat);}

    }


public class UssuriTiger extends Animal {
    int weight;

    public UssuriTiger (String name, String breed, int age, String color, String nutrition, String habitat, int weight){
        super(name,breed,age,color,nutrition,habitat);
        this.weight=weight;
    }
    public void weight(){
        System.out.println("Вес животного: "+ this.weight+ " кг.");
    }
    public void roar(){
        System.out.println("Огонь рычит: Я вас съем!");
    }

    }



public class Horse extends Animal {
    int speed;
    public Horse(String name, String breed, int age, String color, String nutrition, String habitat, int speed) {
        super(name, breed, age, color, nutrition, habitat);
        this.speed = speed;
    }
    public void speed() {
        System.out.println("Скорость животного: " + this.speed + " км/ч");
    }

    public void run(){
        System.out.println("Рысак каждое утро кричит: Игого, я поскакал!");
    }

        }
