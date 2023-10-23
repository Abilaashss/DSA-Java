public class OOPS {
    public static void main(String[] args){
        fish tuna = new fish();
        tuna.eat();



    }
}

//Base Class
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathes(){
        System.out.println("breathes");
    }
}
class fish extends Animal{
    int fins;

    void swim(){
        System.out.println("swims in water");
    }
}