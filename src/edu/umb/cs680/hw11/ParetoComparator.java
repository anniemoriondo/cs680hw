package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2){
        // car1 is better if it has a lower domination count
        // better is "smaller" here because we go from best to worst
        return car2.getDominationCount() - car1.getDominationCount();
    }
}
