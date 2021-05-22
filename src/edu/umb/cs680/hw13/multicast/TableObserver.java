package edu.umb.cs680.hw13.multicast;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class TableObserver implements StockQuoteObserver, DJIAQuoteObserver{

    private HashMap<String, Float> stockQuotes = new HashMap<>();
    private float djiaQuote;

    public TableObserver(StockQuoteObservable stocks, DJIAQuoteObservable djia){
        this.stockQuotes = stocks.getAllQuotes();
        stocks.addObserver(this);
        this.djiaQuote = djia.getQuote();
        djia.addObserver(this);
    }

    public void updateStock(StockEvent event){
        if (! stockQuotes.containsKey(event.getTicker())){
            stockQuotes.put(event.getTicker(), event.getQuote());
        } else {
            stockQuotes.replace(event.getTicker(), event.getQuote());
        }
    }

    public void updateDJIA(DJIAEvent event){
        djiaQuote = event.getQuote();
    }

    public float getDjiaQuote() { return djiaQuote; }

    public float getQuote(String ticker){
        if (stockQuotes.containsKey(ticker)){
            return stockQuotes.get(ticker);
        }
        return -1f;
    }
}
