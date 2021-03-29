package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DVDPlayerTest {
    DVDPlayer cut = DVDPlayer.getInstance();
    State closedNotPlaying = DrawerClosedNotPlaying.getInstance();
    State closedPlaying = DrawerClosedPlaying.getInstance();
    State open = DrawerOpen.getInstance();

    @Test
    public void startOutDrawerClosedNotPlaying(){
        assertEquals(cut.getState(), closedNotPlaying);
    }
}