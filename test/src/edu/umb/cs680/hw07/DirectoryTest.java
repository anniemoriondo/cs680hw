package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class DirectoryTest {
    FileSystem fs;

    private String[] dirToStringArray(Directory d){
        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                d.getName(),
                String.valueOf(d.getSize()),
                d.getCreationTime().toString(),
                d.getParent().getName(),
                String.valueOf(d.countChildren())
        };
        return dirInfo;
    }


    @BeforeAll
    public void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }
}