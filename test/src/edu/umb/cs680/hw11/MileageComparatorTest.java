package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Collections;
import java.util.LinkedList;

public class MileageComparatorTest {

    private static LinkedList<Car> cars;

    @BeforeAll
    public static void setUpCars(){
        cars = CarFixtureInitializer.getCarExamples();
    }

    @Test
    public void verifyMileageSort(){
        String[] expected = {"Subaru Legacy", "Ford Explorer", "Toyota Corolla",
                "Toyota Prius", "Nissan Acura", "Honda Civic"};
        String[] actual = new String[6];
        // Sort the cars from most mileage (worst) to least mileage (best)
        Collections.sort(cars, new MileageComparator());
        // List the cars
        for (int i = 0; i < 6; i++){
            actual[i] = cars.get(i).getMakeAndModel();
        }
        assertArrayEquals(expected, actual);
    }


}