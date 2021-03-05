package oops;

public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car(60);
        c1.setTopSpeed(100);
        int topSpeed = c1.getTopSpeed();
        System.out.println(topSpeed);
    }
}
