package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Collections;
import java.util.LinkedList;

public class YearComparatorLambdaTest {

    private static LinkedList<Car> cars;

    @BeforeAll
    public static void setUpCars(){
        cars = CarFixtureInitializer.getCarExamples();
    }

    @Test
    public void verifyYearSortLambda(){
        String[] expected = {"Ford Explorer", "Subaru Legacy", "Toyota Corolla",
                "Toyota Prius", "Nissan Acura", "Honda Civic"};
        String[] actual = new String[6];
        // Sort the cars from oldest (worst) to newest (best)
        // using a lambda expression
        Collections.sort(cars, (Car car1, Car car2) ->
            {return car1.getYear() - car2.getYear();});
        // List the cars
        for (int i = 0; i < 6; i++){
            actual[i] = cars.get(i).getMakeAndModel();
        }
        assertArrayEquals(expected, actual);
    }


}