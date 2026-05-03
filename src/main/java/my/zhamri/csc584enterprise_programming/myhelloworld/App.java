package my.zhamri.csc584enterprise_programming.myhelloworld;

public class App {
    public static void main(String[] args) {
        Car myCar = new Car();   // Creating object
        myCar.brand = "Toyota";
        myCar.speed = 120;
        myCar.drive();
        System.out.println(myCar.brand);
        System.out.println(myCar.speed);
    }
}
