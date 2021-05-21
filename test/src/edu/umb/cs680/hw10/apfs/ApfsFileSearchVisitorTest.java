package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.LinkedList;

public class ApfsFileSearchVisitorTest {
    private static APFS apfs;
    private static ApfsDirectory root;


    @BeforeAll
    public static void setUpFS(){
        // Initialize file system fixture and count files with Visitor
        apfs = ApfsFixtureInitializer.createAPFS();
        root = (ApfsDirectory) apfs.getRootDirs().getFirst();
    }

    @Test
    public void verifySearchForA(){
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(1, results.size());
        assertEquals(100, results.getFirst().getSize());
    }

    @Test
    public void verifySearchForB(){
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(1, results.size());
        assertEquals(200, results.getFirst().getSize());
    }

    @Test
    public void verifySearchForE(){
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("e");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(1, results.size());
        assertEquals(500, results.getFirst().getSize());
    }

    @Test
    public void verifySearchForZEmpty(){
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("z");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(0, results.size());
    }

    @Test
    public void verifySearchForHomeEmpty(){
        // Make sure we don't find directories
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("home");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(0, results.size());
    }

    @Test
    public void verifySearchForXEmpty(){
        // Make sure we don't find links
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("x");
        root.accept(visitor);
        LinkedList<ApfsFile> results = visitor.getFoundFiles();
        assertEquals(0, results.size());
    }

}