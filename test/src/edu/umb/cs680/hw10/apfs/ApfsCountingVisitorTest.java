package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsCountingVisitorTest {
    private static APFS apfs;
    private static ApfsCountingVisitor visitor = new ApfsCountingVisitor();

    @BeforeAll
    public static void setUpFS(){
        // Initialize file system fixture and count files with Visitor
        apfs = ApfsFixtureInitializer.createAPFS();
        ApfsElement root = (ApfsElement) apfs.getRootDirs().getFirst();
        root.accept(visitor);

    }

    @Test
    public void verifyGetDirNum(){ assertEquals(5, visitor.getDirNum()); }

    @Test
    public void verifyGetFileNum(){ assertEquals(6, visitor.getFileNum()); }

    @Test
    public void verifyGetLinkNum(){ assertEquals(2, visitor.getLinkNum()); }

}