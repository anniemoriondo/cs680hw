package edu.umb.cs680.hw13.multicast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;

public class StockQuoteObservable {

    private HashMap <String, Float> stockQuotes = new HashMap<>();
    private Collection<StockQuoteObserver> observers;

    public StockQuoteObservable(String[] tickers, float[] quotes){
        // Must be the same length
        if (tickers.length != quotes.length){ return; }
        for (int i = 0; i < tickers.length; i++){
            stockQuotes.put(tickers[i], quotes[i]);
        }
    }

    public HashMap<String, Float> getAllQuotes(){
        return this.stockQuotes;
    }

    public void addObserver(StockQuoteObserver observer){
        this.observers.add(observer);
    }

    public void changeQuote(String ticker, float quote){
        if (!stockQuotes.containsKey(ticker)){ 
            stockQuotes.put(ticker, quote);
        } else {
            stockQuotes.replace(ticker, quote);
        }
        notifyObservers(new StockEvent(ticker, quote));
    }

    public void notifyObservers(StockEvent event){
        for (StockQuoteObserver observer : observers){
            observer.updateStock(event);
        }
    }

    public static void main(String[] args){

    }
}
