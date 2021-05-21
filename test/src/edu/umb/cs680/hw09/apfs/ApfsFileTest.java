package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsFileTest {
    private static APFS apfs;
    private static ApfsFile a, b, c, d, e, f;

    /**
     * Lists all details of a file.
     * @param f a file
     * @return an array of file metadata as Strings
     */
    private String[] fileToStringArray(ApfsFile f){
        String parentName = f.getParent() == null ?
                "null" : f.getParent().getName();

        String[] fileInfo = {String.valueOf(f.isDirectory()),
                String.valueOf(f.isLink()),
                f.getName(),
                String.valueOf(f.getSize()),
                parentName,
                f.getOwnerName()};
        return fileInfo;
    }

    @BeforeAll
    public static void setUpFS(){
        // Set up the file system, including files we'll be testing.
        apfs = ApfsFixtureInitializer.createAPFS();
        ApfsDirectory root = (ApfsDirectory) apfs.getRootDirs().get(0);
        ApfsDirectory applications = (ApfsDirectory) root.getChildren().get(0);
        ApfsDirectory home = (ApfsDirectory) root.getChildren().get(1);
        ApfsDirectory code = (ApfsDirectory) home.getChildren().get(0);
        ApfsDirectory pics = (ApfsDirectory) home.getChildren().get(1);

        a = (ApfsFile) applications.getChildren().get(0);
        b = (ApfsFile) home.getChildren().get(2);
        c = (ApfsFile) code.getChildren().get(0);
        d = (ApfsFile) code.getChildren().get(1);
        e = (ApfsFile) pics.getChildren().get(0);
        f = (ApfsFile) pics.getChildren().get(1);
    }

    @Test
    public void verifyFileEqualityA(){
        String[] expected = {"false", "false", "a", "100", "applications", "Annie"};
        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void verifyFileEqualityB(){
        String[] expected = {"false", "false", "b", "200", "home", "Annie"};
        assertArrayEquals(expected, fileToStringArray(b));
    }

    @Test
    public void verifyFileEqualityC(){
        String[] expected = {"false", "false", "c", "300", "code", "Annie"};
        assertArrayEquals(expected, fileToStringArray(c));
    }

    @Test
    public void verifyFileEqualityD(){
        String[] expected = {"false", "false", "d", "400", "code", "Annie"};
        assertArrayEquals(expected, fileToStringArray(d));
    }

    @Test
    public void verifyFileEqualityE(){
        String[] expected = {"false", "false", "e", "500", "pics", "Annie"};
        assertArrayEquals(expected, fileToStringArray(e));
    }

    @Test
    public void verifyFileEqualityF(){
        String[] expected = {"false", "false", "f", "600", "pics", "Annie"};
        assertArrayEquals(expected, fileToStringArray(f));
    }


}