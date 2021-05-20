package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class DirectoryTest {
    // Instance variables from our test fixture.
    private static FileSystem fs;
    private static Directory root;
    private static Directory home;
    private static Directory applications;
    private static Directory code;
    private static Directory pics;

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
        root = fs.getRootDirs().get(0);
        applications = (Directory) root.getChildren().get(0);
        home = (Directory) root.getChildren().get(1);
        code = (Directory) home.getChildren().get(0);
        pics = (Directory) home.getChildren().get(1);
    }

    @Test
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"true", "root", "0", "null", "2"};
        assertArrayEquals(expected, dirToStringArray(root));

    }

    @Test
    public void verifyDirectoryEqualityApplications(){
        String[] expected = {"true", "applications", "0", "root", "1"};
        assertArrayEquals(expected, dirToStringArray(applications));
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"true", "home", "0", "root", "3"};
        assertArrayEquals(expected, dirToStringArray(home));
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"true", "code", "0", "home", "2"};
        assertArrayEquals(expected, dirToStringArray(code));
    }

    @Test
    public void verifyDirectoryEqualityPics(){
        String[] expected = {"true", "pics", "0", "home", "2"};
        assertArrayEquals(expected, dirToStringArray(pics));
    }

    @Test
    public void verifyCountChildrenRoot(){
        assertEquals(2, root.countChildren());
    }

    @Test
    public void verifyCountChildrenApplications(){
        assertEquals(1, applications.countChildren());
    }

    @Test
    public void verifyCountChildrenHome(){
        assertEquals(3, home.countChildren());
    }

    @Test
    public void verifyCountChildrenCode(){
        assertEquals(2, code.countChildren());
    }

    @Test
    public void verifyCountChildrenPics(){
        assertEquals(2, pics.countChildren());
    }
}