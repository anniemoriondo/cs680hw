package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsTest {
    private static APFS apfs;

    @BeforeAll
    public static void setUpFS(){ apfs = ApfsFixtureInitializer.createAPFS(); }

    @Test
    public void verifyRootDirNames(){
        assertEquals("root", apfs.getRootDirs().getFirst().getName());
    }

    @Test
    public void verifyRootDirQuantity(){
        assertEquals(1, apfs.getRootDirs().size());
    }

    @Test
    public void verifyAPFSIdentity(){
        assertEquals("Sample APFS", apfs.getName());
        assertEquals(250000, apfs.getCapacity());
    }
}