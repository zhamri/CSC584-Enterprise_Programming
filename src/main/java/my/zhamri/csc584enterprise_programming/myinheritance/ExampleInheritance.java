package my.zhamri.csc584enterprise_programming.myinheritance;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class App{
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.bark();
        myDog.sound();
    }
}