package edu.umb.cs680.hw06;

public class DVDPlayer {
    private static State state;
    private DVDPlayer(){}
    private static DVDPlayer instance = null;

    public static DVDPlayer getInstance(){
        if(instance == null){
            instance = new DVDPlayer();
            state = DrawerClosedNotPlaying.getInstance();
        }
        return instance;
    }

    public static void changeState(State newState){
        state = newState;
    }

    // Button operations on the DVD player
    public static void openCloseButtonPushed(){
        state.openCloseButtonPushed();
    }

    public static void playButtonPushed(){
        state.playButtonPushed();
    }

    public static void stopButtonPushed(){
        state.stopButtonPushed();
    }

    // Basic functions of the DVD player
    public static void open(){}
    public static void close(){}
    public static void play(){
        // Would the error check go in this message?
    }
    public static void stop(){}



}
