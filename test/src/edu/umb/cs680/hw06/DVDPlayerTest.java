package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * This assumes a DVD is in the tray the whole time.
 * What happens if there is no DVD? This was mentioned once in the
 * slides but the UML diagram did not seem to include this case.
 */
public class DVDPlayerTest {
    State closedNotPlaying = DrawerClosedNotPlaying.getInstance();
    State closedPlaying = DrawerClosedPlaying.getInstance();
    State drawerOpen = DrawerOpen.getInstance();

    @Test
    public void startOutDrawerClosedNotPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        assertEquals(cut.getState(), closedNotPlaying);
    }

    @Test
    public void pushOpenCloseWhenClosedNotPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        cut.openCloseButtonPushed();
        assertEquals(cut.getState(), drawerOpen);
    }

    @Test
    public void pushPlayWhenClosedNotPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        cut.playButtonPushed();
        assertEquals(cut.getState(), closedPlaying);

    }

    @Test
    public void pushStopWhenClosedNotPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        cut.stopButtonPushed();
        assertEquals(cut.getState(), closedNotPlaying);
    }

    @Test
    public void pushOpenCloseWhenClosedPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push play to put player in DrawerClosedPlaying state
        cut.playButtonPushed();
        cut.openCloseButtonPushed();
        assertEquals(cut.getState(), drawerOpen);
    }

    @Test
    public void pushPlayWhenClosedPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push play to put player in DrawerClosedPlaying state
        cut.playButtonPushed();
        // Push play again
        cut.playButtonPushed();
        assertEquals(cut.getState(), closedPlaying);
    }

    @Test
    public void pushStopWhenClosedPlaying(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push play to put player in DrawerClosedPlaying state
        cut.playButtonPushed();
        cut.stopButtonPushed();
        assertEquals(cut.getState(), closedNotPlaying);
    }

    @Test
    public void pushOpenCloseWhenOpen(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push open/close to put player in DrawerOpen state
        cut.openCloseButtonPushed();
        cut.openCloseButtonPushed();
        assertEquals(cut.getState(), closedNotPlaying);
    }

    @Test
    public void pushPlayWhenOpen(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push open/close to put player in DrawerOpen state
        cut.openCloseButtonPushed();
        cut.playButtonPushed();
        assertEquals(cut.getState(), closedPlaying);
    }

    @Test
    public void pushStopWhenOpen(){
        DVDPlayer cut = DVDPlayer.getInstance();
        // Push open/close to put player in DrawerOpen state
        cut.openCloseButtonPushed();
        cut.stopButtonPushed();
        assertEquals(cut.getState(), drawerOpen);
    }
}