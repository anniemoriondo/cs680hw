package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Collections;
import java.util.LinkedList;

public class MileageCompareLambdaTest {

    private static LinkedList<Car> cars;

    @BeforeAll
    public static void setUpCars(){
        cars = CarFixtureInitializer.getCarExamples();
    }

    @Test
    public void verifyMileageSortLambda(){
        String[] expected = {"Subaru Legacy", "Ford Explorer", "Toyota Corolla",
                "Toyota Prius", "Nissan Acura", "Honda Civic"};
        String[] actual = new String[6];
        // Sort the cars from most mileage (worst) to least mileage (best)
        // using a lambda expression
        Collections.sort(cars, (Car car1, Car car2) ->
            {return car2.getMileage() - car1.getMileage();});
        // List the cars
        for (int i = 0; i < 6; i++){
            actual[i] = cars.get(i).getMakeAndModel();
        }
        assertArrayEquals(expected, actual);
    }


}