package edu.umb.cs680.hw05;

import java.lang.System;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car (String make, String model, int mileage, int year, float price){
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    // Getter methods.
    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public int getMileage(){
        return this.mileage;
    }

    public int getYear(){
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public static void main(String[] args){
        Car myCar = new Car("Ford", "Fusion", 0, 2021, 40000);
        System.out.println(myCar.getMake());
        System.out.println(myCar.getModel());
        System.out.println(myCar.getMileage());
        System.out.println(myCar.getYear());
        System.out.println(myCar.getPrice());

    }
}