public class Main {
    public static void main(String[] args) {
        Person valera=new Person("Валера","Иванов",69,null,null);
        Person olga = new Person("Ольга","Иванова",67,null,null);
        Person oleg = new Person("Олег","Петров",65,null,null);
        Person jula = new Person("Юля","Петрова",67,null,null);
        Person alex = new Person("Алексей","Иванов",37,olga,valera);
        Person eva  = new Person("Ева","Иванова",37,jula,oleg);
        Person gosha= new Person("Гоша","Иванов",10,eva,alex);
        gosha.tell();


    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private int hp = 100;
    private Person mother;
    private Person father;
    public Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
    public String getName() {
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public Person getMother(){
        return this.mother;
    }
    public void tell(){
        System.out.println("Меня зовут "+this.name+"\n"+"Имя моей мамы: "+ this.mother.name+"\n"+ "Имя моего папы: "
                + this.father.name + "\n"+"У меня две бабушки,бабушка "+ this.mother.mother.name+" и бабушка "+this.father.mother.name +"\n"+
                "У меня два деда,дед "+this.mother.father.name + " и дед " + this.father.father.name);

    }
    }
