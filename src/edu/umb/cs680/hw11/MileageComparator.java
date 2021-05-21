package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2){
        // car1 is better if it has lower mileage
        return car2.getMileage() - car1.getMileage();
    }
}
