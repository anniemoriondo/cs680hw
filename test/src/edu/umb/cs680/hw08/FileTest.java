package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class FileTest {
    private static FileSystem fs;
    private static File a, b, c, d, e, f;

    /**
     * Lists all details of a file.
     * @param f a file
     * @return an array of file metadata as Strings
     */
    private String[] fileToStringArray(File f){
        String parentName = f.getParent() == null ?
                "null" : f.getParent().getName();

        String[] fileInfo = {String.valueOf(f.isDirectory()),
                            String.valueOf(f.isLink()),
                            f.getName(),
                            String.valueOf(f.getSize()),
                            parentName};
        return fileInfo;
    }

    @BeforeAll
    public static void setUpFS(){
        // Set up the file system, including files we'll be testing.
        fs = TestFixtureInitializer.createFS();
        Directory root = fs.getRootDirs().get(0);
        Directory applications = (Directory) root.getChildren().get(0);
        Directory home = (Directory) root.getChildren().get(1);
        Directory code = (Directory) home.getChildren().get(0);
        Directory pics = (Directory) home.getChildren().get(1);

        a = (File) applications.getChildren().get(0);
        b = (File) home.getChildren().get(2);
        c = (File) code.getChildren().get(0);
        d = (File) code.getChildren().get(1);
        e = (File) pics.getChildren().get(0);
        f = (File) pics.getChildren().get(1);
    }

    @Test
    public void verifyFileEqualityA(){
        String[] expected = {"false", "false", "a", "100", "applications"};
        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void verifyFileEqualityB(){
        String[] expected = {"false", "false", "b", "200", "home"};
        assertArrayEquals(expected, fileToStringArray(b));
    }

    @Test
    public void verifyFileEqualityC(){
        String[] expected = {"false", "false", "c", "300", "code"};
        assertArrayEquals(expected, fileToStringArray(c));
    }

    @Test
    public void verifyFileEqualityD(){
        String[] expected = {"false", "false", "d", "400", "code"};
        assertArrayEquals(expected, fileToStringArray(d));
    }

    @Test
    public void verifyFileEqualityE(){
        String[] expected = {"false", "false", "e", "500", "pics"};
        assertArrayEquals(expected, fileToStringArray(e));
    }

    @Test
    public void verifyFileEqualityF(){
        String[] expected = {"false", "false", "f", "600", "pics"};
        assertArrayEquals(expected, fileToStringArray(f));
    }


}