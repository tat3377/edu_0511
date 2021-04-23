package Drevo;
public class Main {
    public static void main(String[] args) {
        Familymember sergei = new Familymember("Сергей",70,null,null,null,null,null,null);
        Familymember polina = new Familymember("Полина", 60, null, null,null,null,null,null);
        Familymember misha = new Familymember("Михаил", 64, null, null,null,null,null,null);
        Familymember rita = new Familymember("Маргарита", 59, null, null,null,null,null,null);
        Familymember galina = new Familymember("Галина", 36, rita, misha,null,null,null,null);
        Familymember petr = new Familymember("Пётр", 42, polina, sergei,null,null,null,null);
        Familymember nastia = new Familymember("Анастасия", 16, galina, petr,misha,rita,sergei,polina);
        nastia.getInfo();
        petr.getInfo();
        galina.getInfo();
        
    }

}
 class Familymember {
     String firstname;
     int age;
     Familymember mother;
     Familymember father;
     Familymember grandfather1;
     Familymember grandmother1;
     Familymember grandfather2;
     Familymember grandmother2;

     public Familymember(String firstname, int age, Familymember mother, Familymember father,
                         Familymember grandfather1, Familymember grandmother1, Familymember grandfather2,
                         Familymember grandmother2) {
         this.firstname = firstname;
         this.age = age;
         this.mother = mother;
         this.father = father;
         this.grandfather1 = grandfather1;
         this.grandmother1 = grandmother1;
         this.grandfather2 = grandfather2;
         this.grandmother2 = grandmother2;
     }
     public void getInfo(){
         String info = "Меня зовут "+ this.firstname+" Мой возраст: "+ this.age+"\n";
         if (this.mother !=null){
             info +="Мою маму зовут "+  this.mother.firstname+ "Её возраст: " +this.mother.age+"\n";
         }
         if (this.father !=null){
             info += "Моего папу зовут "+ this.father.firstname+ "Eго возраст: " +this.father.age+"\n";
         }
         if (this.grandfather1 !=null){
             info += "Дедушку по маминой линии зовут "+ this.mother.grandfather1.firstname+ " Его возраст: " +this.grandfather1.age;
         }
         if (this.grandfather2 !=null){
             info += "Дедушку по папиной линии зовут "+ this.mother.grandfather2.firstname+" Его возраст: " +this.grandfather2.age;
         }
         if (this.grandfather1 !=null){
             info += "Бабушку по маминой линии зовут "+ this.mother.grandmother1.firstname+" Её возраст: " +this.grandmother1.age;
         }
         if (this.grandfather1 !=null){
             info += "Бабушку по папиной линии зовут "+ this.father.grandmother2.firstname+" Её возраст: " +this.grandmother2.age;
         }

         System.out.println(info);
     }

     public String getFirstname() {
         return firstname;
     }

     public int getAge() {
         return age;
     }

     public Familymember getMother() {
         return mother;
     }

     public Familymember getFather() {
         return father;
     }

     public Familymember getGrandfather1() {
         return grandfather1;
     }

     public Familymember getGrandmother1() {
         return grandmother1;
     }

     public Familymember getGrandfather2() {
         return grandfather2;
     }

     public Familymember getGrandmother2() {
         return grandmother2;
     }
}
