package io.goorm.basicJava;

public class TestMain2 {
    public static void main(String[] args) {
        Car2 car = new Car2();
//        System.out.println(car.name);
//        System.out.println(car.color);
//        System.out.println(car.maxSpeed);
//
//        car.name = "소나타";
//        System.out.println(car.name);
//        System.out.println(car.color);
//        System.out.println(car.maxSpeed);

        System.out.println(car.getColor());
        System.out.println(car.getName());
        System.out.println(car.getMaxSpeed());

        car.setName("아반떼2");
        System.out.println(car.getName());


    }
}
