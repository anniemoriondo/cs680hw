package edu.umb.cs680.hw13.observable;

public class DJIAEvent {
    private float quote;

    public DJIAEvent (float quote){
        this.quote = quote;
    }

    public float getQuote(){ return this.quote; }
}
