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
        System.out.println("Is this working?");
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
        System.out.println(expected);
        System.out.println(dirToStringArray(actual));
        assertArrayEquals(expected, dirToStringArray(actual));

    }
}