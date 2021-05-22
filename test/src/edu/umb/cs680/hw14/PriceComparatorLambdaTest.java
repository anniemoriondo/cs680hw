package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Collections;
import java.util.LinkedList;

public class PriceComparatorLambdaTest {

    private static LinkedList<Car> cars;

    @BeforeAll
    public static void setUpCars(){
        cars = CarFixtureInitializer.getCarExamples();
    }

    @Test
    public void verifyPriceSortLambda(){
        String[] expected = { "Nissan Acura", "Toyota Prius", "Subaru Legacy",
                "Toyota Corolla", "Ford Explorer", "Honda Civic"};
        String[] actual = new String[6];
        // Sort the cars from most expensive (worst) to least expensive (best)
        Collections.sort(cars, (Car car1, Car car2) ->
            {return car2.getPrice() - car1.getPrice();});
        // List the cars
        for (int i = 0; i < 6; i++){
            actual[i] = cars.get(i).getMakeAndModel();
        }
        assertArrayEquals(expected, actual);
    }


}