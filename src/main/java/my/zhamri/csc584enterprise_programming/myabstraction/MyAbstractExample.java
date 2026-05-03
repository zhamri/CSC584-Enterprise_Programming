package my.zhamri.csc584enterprise_programming.myabstraction;

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }
}

class App1 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
    }
}
