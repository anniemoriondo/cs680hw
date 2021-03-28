package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest{

    private String[] carToStringArray(Car thisCar){
        return {thisCar.getMake(), thisCar.getModel(),
                (String) thisCar.getYear()};

    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        car1 = new Car("Subaru", "Legacy", 60000, 2014, 17000);
        car1Array = carToStringArray(car1);
        car2 = new Car("Subaru", "Legacy", 45000, 2014, 19000);
        car2Array = carToStringArray(car2);
        String[] expected = {"Subaru", "Legacy", "2014"};
        assertArrayEquals(expected, car1Array);
        assertArrayEquals(expected, car2Array);
        assertArrayEquals(car1Array, car2Array);
    }

}