package io.goorm.basicJava;

public class TestMain {

    int sum(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {

        Car car = new Car();
        car.name = "아반떼";
        car.color = "red";
        car.maxSpeed = "200km";

        System.out.println(car.name);
        System.out.println(car.color);
        System.out.println(car.maxSpeed);

        Car car2 = new Car();
        car2.name = "소나타";
        car2.color = "white";
        car2.maxSpeed = "250km";

        System.out.println(car2.name);
        System.out.println(car2.color);
        System.out.println(car2.maxSpeed);

        Car car3 = new Car("제네시스", "black", "300km");
        System.out.println(car3.name);
        System.out.println(car3.color);
        System.out.println(car3.maxSpeed);

        car.sound();
        TestMain testMain = new TestMain();
        System.out.println(testMain.sum(1, 2));

        SuperCar superCar = new SuperCar("페라리", "red", "400km");
        System.out.println(superCar.name);
        System.out.println(superCar.color);
        System.out.println(superCar.maxSpeed);

        SuperCar superCar2 = new SuperCar("부가티", "black", "400km", "500km");
        System.out.println(superCar2.name);
        System.out.println(superCar2.color);
        System.out.println(superCar2.maxSpeed);
        System.out.println(superCar2.booster);

        superCar2.sound();

    }
}
