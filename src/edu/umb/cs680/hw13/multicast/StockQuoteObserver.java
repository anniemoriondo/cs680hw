package edu.umb.cs680.hw13.multicast;

public interface StockQuoteObserver {

    void updateStock(StockEvent event);
}
