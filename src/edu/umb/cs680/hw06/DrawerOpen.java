package edu.umb.cs680.hw06;

public class DrawerOpen implements State{
    private DrawerOpen(){}
    public static DrawerOpen instance = null;
    public static DrawerOpen getInstance(){
        if(instance == null){
            instance = new DrawerOpen();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed(){
        DVDPlayer.close();
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed(){
        DVDPlayer.close();
        DVDPlayer.play();
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {}
}
