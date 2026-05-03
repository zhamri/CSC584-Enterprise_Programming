package my.zhamri.csc584enterprise_programming.myabstraction;

interface Animal {
    void sound();
}

class Cow implements Animal {
    @Override
    public void sound() {
        System.out.println("Moo");
    }
}

class App2 {
    public static void main(String[] args) {
        Cow myCow = new Cow();
        myCow.sound();
    }
}
