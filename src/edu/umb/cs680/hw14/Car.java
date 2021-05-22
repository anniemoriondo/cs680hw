package edu.umb.cs680.hw14;

import java.util.LinkedList;

public class Car {
    private String make, model;
    private int mileage, year, price;

    // Domination count, for Pareto comparisons.
    private int dominationCount = 0;

    public Car(String make, String model, int mileage, int year, int price){
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

    public String getMakeAndModel() { return this.make + " " + this.model;}

    public int getMileage(){
        return this.mileage;
    }

    public int getYear(){
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }

    public int getDominationCount(){ return this.dominationCount;}

    public void setDominationCount(int newCount){
        this.dominationCount = newCount;
    }

    // Does this car dominate another car?
    public boolean dominates(Car otherCar){
        // Does this car tie the other car on all criteria?
        boolean priceTies = this.price <= otherCar.getPrice();
        boolean yearTies = this.year >= otherCar.getYear();
        boolean mileageTies = this.mileage <= otherCar.getMileage();
        // Is at least one criterion strictly better?
        boolean oneBetter = this.price < otherCar.getPrice() ||
                this.year > otherCar.getYear() ||
                this.mileage < otherCar.getMileage();

        return priceTies && yearTies && mileageTies && oneBetter;
    }

    public static void computeDominationCounts(LinkedList<Car> cars){
        for (Car thisCar : cars){
            thisCar.setDominationCount(0);
        }
        for (Car thisCar : cars){
            for (Car thatCar : cars){
                if (thisCar.dominates(thatCar)){
                    // Increase the domination count of the car that gets dominated
                    thatCar.setDominationCount(thatCar.getDominationCount() + 1);
                }
            }
        }
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