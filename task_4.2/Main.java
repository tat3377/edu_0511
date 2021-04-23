public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Дог",5);

        dog.setName("Дог");
        dog.setAge (5);

        System.out.println("Имя собаки: " + dog.getName());
        System.out.println("Возраст собаки: "+ dog.getAge());
    }
}



public class Dog {

 private String name = "Дог";
 private int age = 5;
  public Dog(String name,int age) {
      this.name = name;
      this.age = age;
  }
    public String getName(){
      return name;
  }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
