package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ObservablesTest {
    private StockQuoteObservable stockQuotes;
    private DJIAQuoteObservable djiaQuotes;
    private PiechartObserver piechartObserver;

    @BeforeAll
    public static void setUp(){
        // Stock prices as of 10:30PM on 21 May 2021, according to Apple Stocks!
        String[] stocks = {"GOOG", "AAPL", "DAL", "PFE"};
        float[] quotes = {2345.1f, 125.43f, 45.21f, 39.95f};
        stockQuotes = new StockQuoteObservable(stocks, quotes);
        djiaQuotes = new DJIAQuoteObservable();
        piechartObserver = new PiechartObserver(stockQuotes, djiaQuotes);
        threeDObserver = new ThreeDObserver(stockQuotes, djiaQuotes);
        tableObserver = new TableObserer(stockQuotes, djiaQuotes);
    }

    @Test
    public void verifyChangePriceGoogle(){
        float newPrice = 2219.56f;
        stockQuotes.changeQuote("GOOG", newPrice);
        assertEqual(newPrice, piechartObserver.getQuote("GOOG"));
        assertEqual(newPrice, tableObserver.getQuote("GOOG"));
        assertEqual(newPrice, threeDObserver.getQuote("GOOG"));

    }

    @Test
    public void verifyChangePricePfizer(){
        float newPrice = 50.34f;
        stockQuotes.changeQuote("PFE", newPrice);
        assertEqual(newPrice, piechartObserver.getQuote("PFE"));
        assertEqual(newPrice, tableObserver.getQuote("PFE"));
        assertEqual(newPrice, threeDObserver.getQuote("PFE"));
    }

    @Test
    public void verifyChangePriceAppleAndDelta(){
        float newApplePrice = 119.47f;
        float newDeltaPrice = 49.45f;
        stockQuotes.changeQuote("AAPL", newApplePrice);
        stockQuotes.changeQuote("DAL", newDeltaPrice);

        assertEqual(newApplePrice, piechartObserver.getQuote("AAPL"));
        assertEqual(newApplePrice, tableObserver.getQuote("AAPL"));
        assertEqual(newApplePrice, threeDObserver.getQuote("AAPL"));

        assertEqual(newDeltaPrice, piechartObserver.getQuote("DAL"));
        assertEqual(newDeltaPrice, tableObserver.getQuote("DAL"));
        assertEqual(newDeltaPrice, threeDObserver.getQuote("DAL"));

    }

    @Test
    public void verifyChangeDJIA(){
        float newPrice = 34002.09f;
        djiaQuotes.changeQuote(newPrice);

        assertEqual(newPrice, piechartObserver.getDjiaQuote();
        assertEqual(newPrice, tableObserver.getDjiaQuote();
        assertEqual(newPrice, threeDObserver.getDjiaQuote();
    }

    @Test
    public void verifyChangeDJIAAndGoogle(){
        float newDJIAPrice = 34340.89f;
        float newGooglePrice = 2100.36f;
        stockQuotes.changeQuote("GOOG", newGooglePrice);
        djiaQuotes.changeQuote(newDJIAPrice);

        assertEqual(newGooglePrice, piechartObserver.getQuote("GOOG"));
        assertEqual(newGooglePrice, tableObserver.getQuote("GOOG"));
        assertEqual(newGooglePrice, threeDObserver.getQuote("GOOG"));

        assertEqual(newDJIAPrice, piechartObserver.getDjiaQuote();
        assertEqual(newDJIAPrice, tableObserver.getDjiaQuote();
        assertEqual(newDJIAPrice, threeDObserver.getDjiaQuote();
    }
}