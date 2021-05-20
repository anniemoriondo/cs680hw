package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileSystemTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void verifyRootDirNames(){
        assertEquals("root", fs.getRootDirs().getFirst().getName());
    }

    @Test
    public void verifyRootDirQuantity(){
        assertEquals(1, fs.getRootDirs().size());
    }
}