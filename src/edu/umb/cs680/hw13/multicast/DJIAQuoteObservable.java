package edu.umb.cs680.hw13.multicast;

import java.util.Observable;
import java.util.Collection;

public class DJIAQuoteObservable {

    // DJIA as of Friday May 21, 2021, 10:30 PM
    private float quote = 34207.84f;

    private Collection<DJIAQuoteObserver> observers;

    public DJIAQuoteObservable(){}

    public DJIAQuoteObservable(float currentQuote){
        this.quote = currentQuote;
    }

    public float getQuote() { return quote; }

    public void addObserver(DJIAQuoteObserver observer){
        this.observers.add(observer);
    }

    public void notifyObservers(DJIAEvent event){
        for (DJIAQuoteObserver observer : observers){
            observer.updateDJIA(event);
        }
    }

    public void changeQuote(float quote){
        this.quote = quote;
        notifyObservers(new DJIAEvent(quote));
    }
}
