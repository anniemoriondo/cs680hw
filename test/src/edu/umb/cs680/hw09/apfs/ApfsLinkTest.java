package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsLinkTest {
    private static APFS apfs;
    private static ApfsLink x, y;

    /**
     * Lists metadata pertaining to a link
     * @param l a link
     * @return an array of link metadata
     */
    private String[] linkToStringArray(ApfsLink l){
        String[] metadata = { String.valueOf(l.isDirectory()),
                String.valueOf(l.isLink()),
                l.getName(),
                String.valueOf(l.getSize()),
                l.getParent().getName(),
                l.getTarget().getName(),
                l.getOwnerName()};
        return metadata;
    }

    @BeforeAll
    public static void setUpFS(){
        // Set up our file system fixture and initialize x and y.
        apfs = ApfsFixtureInitializer.createAPFS();
        ApfsDirectory root = (ApfsDirectory) apfs.getRootDirs().get(0);
        ApfsDirectory home = (ApfsDirectory) root.getChildren().get(1);
        ApfsDirectory code = (ApfsDirectory) home.getChildren().get(0);

        x = (ApfsLink) home.getChildren().getLast();
        y = (ApfsLink) code.getChildren().getLast();
    }

    @Test
    public void verifyLinkEqualityX(){
        String[] expected = {"false", "true", "x", "0", "home", "applications", "Annie"};
        assertArrayEquals(expected, linkToStringArray(x));
    }

    @Test
    public void verifyLinkEqualityY(){
        String[] expected = {"false", "true", "y", "0", "code", "a", "Annie"};
        assertArrayEquals(expected, linkToStringArray(y));
    }

    @Test
    public void verifyTargetNameX(){ assertEquals("applications", x.targetName()); }

    @Test
    public void verifyTargetNameY(){ assertEquals("a", y.targetName()); }

    @Test
    public void verifyTargetLocationX(){
        assertEquals("root", x.targetLocation());
    }

    @Test
    public void verifyTargetLocationY(){
        assertEquals("applications", y.targetLocation());
    }

    @Test
    public void verifyTargetSizeX(){
        assertEquals(100, x.targetSize());
    }

    @Test
    public void verifyTargetSizeY(){ assertEquals(100, y.targetSize()); }

    @Test
    public void verifyTargetIsDirectoryX(){ assertTrue(x.targetIsDirectory()); }

    @Test
    public void verifyTargetIsDirectoryY(){
        assertFalse(y.targetIsDirectory());
    }

    @Test
    public void verifyTargetIsLinkX(){ assertFalse(x.targetIsLink()); }

    @Test
    public void verifyTargetIsLinkY(){
        assertFalse(y.targetIsLink());
    }

}