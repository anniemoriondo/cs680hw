package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State{
    private DrawerClosedNotPlaying(){}
    public static DrawerClosedNotPlaying instance = null;
    public static DrawerClosedNotPlaying getInstance(){
        if (instance == null){
            instance = new DrawerClosedNotPlaying();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed(){
        DVDPlayer.open();
        DVDPlayer.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlayer.play();
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {}
}
