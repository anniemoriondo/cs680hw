package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void primesFrom3To20(){
        PrimeGenerator cut = new PrimeGenerator(3, 20);
        cut.generatePrimes();
        Long[] expected = {3L, 5L, 7L, 11L, 13L, 17L, 19L};
        Object[] actual = cut.getPrimes().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void primesFrom50To20Error(){
        try{
            PrimeGenerator cut = new PrimeGenerator(50, 20);
            fail("from parameter must be higher than to parameter");
        }
        catch(RuntimeException actualException){
            String expectedException = "Wrong input values: from=50 to=20";
            assertEquals(expectedException, actualException.getMessage());
        }
    }

    @Test
    public void primesFrom11To11Error(){
        try{
            PrimeGenerator cut = new PrimeGenerator(11, 11);
            fail("from parameter must be higher than to parameter");
        }
        catch(RuntimeException actualException){
            String expectedException = "Wrong input values: from=11 to=11";
            assertEquals(expectedException, actualException.getMessage());
        }
    }

    @Test
    public void primesFrom11To12(){
        PrimeGenerator cut = new PrimeGenerator(11, 12);
        cut.generatePrimes();
        Long[] expected = {11L};
        Object[] actual = cut.getPrimes().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void primesFromNegative5To5Error(){
        try {
            PrimeGenerator cut = new PrimeGenerator(-5, 5);
            fail("cannot start at a negative number");
        }
        catch(RuntimeException actualException){
            String expectedException = "Wrong input values: from=-5 to=5";
            assertEquals(expectedException, actualException.getMessage());
        }
    }
}
