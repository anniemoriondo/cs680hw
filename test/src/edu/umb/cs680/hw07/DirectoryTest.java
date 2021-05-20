package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class DirectoryTest {
    private static FileSystem fs;

    private String[] dirToStringArray(Directory d){
        String parentName = d.getParent() == null ?
                "null" : d.getParent().getName();

        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                d.getName(),
                String.valueOf(d.getSize()),
                //d.getCreationTime().toString(),
                parentName,
                String.valueOf(d.countChildren())
        };
        return dirInfo;
    }

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"true", "root", "0", "null", "2"};
        Directory actual = fs.getRootDirs().getFirst();
        assertArrayEquals(expected, dirToStringArray(actual));

    }

    @Test
    public void verifyDirectoryEqualityApplications(){
        String[] expected = {"true", "applications", "0", "root", "1"};
        // Get the `applications` directory.
        Directory actual = (Directory)
                fs.getRootDirs().getFirst().getChildren().getFirst();
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"true", "home", "0", "root", "3"};
        // Get the `home` directory.
        Directory actual = (Directory)
                fs.getRootDirs().getFirst().getChildren().getLast();
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"true", "code", "0", "home", "2"};
        // Get the `code` directory.
        Directory parent = (Directory) fs.getRootDirs().getFirst().getChildren().getLast();
        Directory actual = (Directory) parent.getChildren().getFirst();
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityPics(){
        String[] expected = {"true", "pics", "0", "home", "2"};
        // Get the `pics` directory.
        Directory parent = (Directory) fs.getRootDirs().getFirst().getChildren().getLast();
        Directory actual = (Directory) parent.getChildren().get(1);
        assertArrayEquals(expected, dirToStringArray(actual));
    }
}