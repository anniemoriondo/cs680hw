package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{
    private DrawerClosedPlaying(){}
    public static DrawerClosedPlaying instance = null;
    public static DrawerClosedPlaying getInstance(){
        if (instance == null){
            instance = new DrawerClosedPlaying();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed(){
        DVDPlayer.stop();
        DVDPlayer.open();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed(){}

    @Override
    public void stopButtonPushed() {
        DVDPlayer.stop();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }
}
