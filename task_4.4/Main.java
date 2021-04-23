public class Main {
    public static void main(String[] args) {
        Dog pluto = new Dog("Pluto",70,10);
        Cat tom = new Cat("Tom",5,"чёрный");
        Mouse jerryMouse = new Mouse("Jerry", 3, 50, "чёрный");
        Mouse mikkiMouse = new Mouse("Mikki", 2, 40, "белый");
        pluto.tell ();
        tom.tell ();
        jerryMouse.tell ();
        mikkiMouse.tell ();

    }
}


public class Dog {
    String name;
    int height;
    int tail;

    public Dog(String name,int height,int tail){
    this.name = name;
    this.height = height;
    this.tail = tail;
    }

   public void tell(){
       System.out.println("Привет,меня зовут "+this.name+"."+  " "+
               "Мой рост "+this.height+"см. "+" " +"Длина моего хвоста "+ this.tail+"см. ");
   }
}


public class Cat  {
    String name;
    public int age;
    public String colour;

    public Cat(String name,int age,String colour) {
        this.name = name;
    this.age = age;
    this.colour = colour;
    }
    public void tell(){
        System.out.println("Привет,меня зовут "+this.name+"."+  " "+
                "Мне исполнилось "+this.age+"лет. "+" " +"Цвет моей шерсти: "+ this.colour);
    }
}

public class Mouse {
    public String name;
    public int age;
    public int height;
    public String colour;

    public Mouse(String name, int age, int height, String colour) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.colour =colour;
    }
    public void tell(){
        System.out.println("Привет,меня зовут "+this.name+"."+  " "+ "Мне исполнилось "+this.age+"лет. "+" "+
                "Мой рост "+this.height+"см. "+" " +"Цвет моей шерсти: "+ this.colour);
    }
}
