package edu.umb.cs680.hw13.observable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ObservablesTest {
    private static StockQuoteObservable stockQuotes;
    private static DJIAQuoteObservable djiaQuotes;
    private static PiechartObserver piechartObserver;
    private static ThreeDObserver threeDObserver;
    private static TableObserver tableObserver;

    @BeforeAll
    public static void setUp(){
        // Stock prices as of 10:30PM on 21 May 2021, according to Apple Stocks!
        String[] stocks = {"GOOG", "AAPL", "DAL", "PFE"};
        float[] quotes = {2345.1f, 125.43f, 45.21f, 39.95f};
        stockQuotes = new StockQuoteObservable(stocks, quotes);
        djiaQuotes = new DJIAQuoteObservable();
        piechartObserver = new PiechartObserver(stockQuotes, djiaQuotes);
        threeDObserver = new ThreeDObserver(stockQuotes, djiaQuotes);
        tableObserver = new TableObserver(stockQuotes, djiaQuotes);
    }

    @Test
    public void verifyChangePriceGoogle(){
        float newPrice = 2219.56f;
        stockQuotes.changeQuote("GOOG", newPrice);
        assertEquals(newPrice, piechartObserver.getQuote("GOOG"));
        assertEquals(newPrice, tableObserver.getQuote("GOOG"));
        assertEquals(newPrice, threeDObserver.getQuote("GOOG"));

    }

    @Test
    public void verifyChangePricePfizer(){
        float newPrice = 50.34f;
        stockQuotes.changeQuote("PFE", newPrice);
        assertEquals(newPrice, piechartObserver.getQuote("PFE"));
        assertEquals(newPrice, tableObserver.getQuote("PFE"));
        assertEquals(newPrice, threeDObserver.getQuote("PFE"));
    }

    @Test
    public void verifyChangePriceAppleAndDelta(){
        float newApplePrice = 119.47f;
        float newDeltaPrice = 49.45f;
        stockQuotes.changeQuote("AAPL", newApplePrice);
        stockQuotes.changeQuote("DAL", newDeltaPrice);

        assertEquals(newApplePrice, piechartObserver.getQuote("AAPL"));
        assertEquals(newApplePrice, tableObserver.getQuote("AAPL"));
        assertEquals(newApplePrice, threeDObserver.getQuote("AAPL"));

        assertEquals(newDeltaPrice, piechartObserver.getQuote("DAL"));
        assertEquals(newDeltaPrice, tableObserver.getQuote("DAL"));
        assertEquals(newDeltaPrice, threeDObserver.getQuote("DAL"));

    }

    @Test
    public void verifyChangeDJIA(){
        float newPrice = 34002.09f;
        djiaQuotes.changeQuote(newPrice);

        assertEquals(newPrice, piechartObserver.getDjiaQuote());
        assertEquals(newPrice, tableObserver.getDjiaQuote());
        assertEquals(newPrice, threeDObserver.getDjiaQuote());
    }

    @Test
    public void verifyChangeDJIAAndGoogle(){
        float newDJIAPrice = 34340.89f;
        float newGooglePrice = 2100.36f;
        stockQuotes.changeQuote("GOOG", newGooglePrice);
        djiaQuotes.changeQuote(newDJIAPrice);

        assertEquals(newGooglePrice, piechartObserver.getQuote("GOOG"));
        assertEquals(newGooglePrice, tableObserver.getQuote("GOOG"));
        assertEquals(newGooglePrice, threeDObserver.getQuote("GOOG"));

        assertEquals(newDJIAPrice, piechartObserver.getDjiaQuote());
        assertEquals(newDJIAPrice, tableObserver.getDjiaQuote());
        assertEquals(newDJIAPrice, threeDObserver.getDjiaQuote());
    }
}