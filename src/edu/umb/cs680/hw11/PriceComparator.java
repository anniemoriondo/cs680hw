package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2){
        // car1 is better if it has a lower price
        return car2.getPrice() - car1.getPrice();
    }
}
