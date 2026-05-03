package my.zhamri.csc584enterprise_programming.mypolymorphism;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

class App{
    public static void main(String[] args) {
        Cat mycat = new Cat();
        mycat.sound();
    }
}