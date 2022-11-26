package io.goorm.basicJava;

public class Car {
    String name;
    String maxSpeed;
    String color;

    public Car(String name, String maxSpeed, String color){
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Car() {}

    public void sound(){
        System.out.println("부아아앙");
    }

}
