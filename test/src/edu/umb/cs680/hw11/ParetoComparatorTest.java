package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Collections;
import java.util.LinkedList;

public class ParetoComparatorTest {

    private static LinkedList<Car> cars;

    @BeforeAll
    public static void setUpCars(){
        cars = CarFixtureInitializer.getCarExamples();
    }

    @Test
    public void verifyParetoSort(){
        String[] expected = { "Honda Civic", "Ford Explorer", "Toyota Corolla",
                "Nissan Acura", "Toyota Prius", "Subaru Legacy"};
        String[] actual = new String[6];
        // Sort the cars from best to worst by Pareto comparison
        Car.computeDominationCounts(cars);
        Collections.sort(cars, new ParetoComparator());
        // List the cars
        for (int i = 0; i < 6; i++){
            actual[i] = cars.get(i).getMakeAndModel();
        }
        assertArrayEquals(expected, actual);
    }


}