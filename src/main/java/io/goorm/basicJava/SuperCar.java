package io.goorm.basicJava;

public class SuperCar extends Car{

    String booster;

    public SuperCar(String name, String maxSpeed, String color) {
        super(name, maxSpeed, color);
    }

    public SuperCar(String name, String maxSpeed, String color, String booster) {
        super(name, maxSpeed, color);
        this.booster = booster;
    }

    public SuperCar() {
    }

    @Override
    public void sound() {
        System.out.println("푸쑤우웅");
    }
}
