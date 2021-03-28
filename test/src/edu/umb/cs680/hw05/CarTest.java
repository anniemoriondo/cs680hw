package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.Integer;

public class CarTest{

    private String[] carToStringArray(Car thisCar){
        String make = thisCar.getMake();
        String model = thisCar.getModel();
        Integer year = thisCar.getYear();
        String yearString = year.toString();
        String[] thisCarArray = {make, model, yearString};
        return thisCarArray;

    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        Car car1 = new Car("Subaru", "Legacy", 60000, 2014, 17000);
        String[] car1Array = carToStringArray(car1);
        Car car2 = new Car("Subaru", "Legacy", 45000, 2014, 19000);
        String[] car2Array = carToStringArray(car2);
        String[] expected = {"Subaru", "Legacy", "2014"};
        assertArrayEquals(expected, car1Array);
        assertArrayEquals(expected, car2Array);
        assertArrayEquals(car1Array, car2Array);
    }

}