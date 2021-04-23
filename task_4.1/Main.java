public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Жужик");
        cat.setName("Жужик");
        System.out.println(cat.getName());
    }
}


public class Cat {
   private String name = "безымянный кот";
    Cat (String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        name=name;
    }
}
