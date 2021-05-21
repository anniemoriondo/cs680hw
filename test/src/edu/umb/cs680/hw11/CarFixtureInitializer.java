package edu.umb.cs680.hw11;

import java.util.LinkedList;

public class CarFixtureInitializer {

    public static LinkedList<Car> getCarExamples(){
        LinkedList<Car> cars = new LinkedList();

        // String make, String model, int mileage, int year, int price
        cars.add(new Car("Ford", "Explorer", 60000, 2012, 12000));
        cars.add(new Car("Subaru", "Legacy", 120000, 2015, 11000));
        cars.add(new Car("Toyota", "Corolla", 120000, 2017, 12000));
        cars.add(new Car("Nissan", "Acura", 0, 2020, 30000));
        cars.add(new Car("Toyota", "Prius", 15000, 2017, 28000));

        return cars;
    }
}