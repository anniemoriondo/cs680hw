package edu.umb.cs680.hw14;

import java.util.LinkedList;

public class CarFixtureInitializer {

    public static LinkedList<Car> getCarExamples(){
        LinkedList<Car> cars = new LinkedList();

        // String make, String model, int mileage, int year, int price
        cars.add(new Car("Ford", "Explorer", 60000, 2015, 15000));
        cars.add(new Car("Subaru", "Legacy", 90000, 2015, 17000));
        cars.add(new Car("Toyota", "Corolla", 15000, 2017, 17000));
        cars.add(new Car("Nissan", "Acura", 0, 2020, 31000));
        cars.add(new Car("Toyota", "Prius", 15000, 2017, 30000));
        cars.add(new Car("Honda", "Civic", 0, 2021, 15000));

        return cars;
    }
}