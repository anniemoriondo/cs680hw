package edu.umb.cs680.hw06;

import java.lang.System;

public class DVDPlayer {
    private State state;
    private DVDPlayer(State state){
        this.state = state;
    }
    private static DVDPlayer instance = null;

    public static DVDPlayer getInstance(){
        if(instance == null){
            instance = new DVDPlayer(DrawerClosedNotPlaying.getInstance());
        }
        return instance;
    }

    public void changeState(State newState){
        this.state = newState;
    }

    public State getState(){
        return this.state;
    }

    // Button operations on the DVD player
    public void openCloseButtonPushed(){this.state.openCloseButtonPushed(); }

    public void playButtonPushed(){
        this.state.playButtonPushed();
    }

    public void stopButtonPushed(){
        this.state.stopButtonPushed();
    }

    // Basic functions of the DVD player
    public void open(){}
    public void close(){}
    public void play(){
        // Would the error check go in this method?
    }
    public void stop(){}

    public static void main(String[] args){
        System.out.println(
                getInstance().state == DrawerClosedNotPlaying.getInstance());

    }



}
