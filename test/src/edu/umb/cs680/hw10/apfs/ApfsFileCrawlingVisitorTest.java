package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.LinkedList;

public class ApfsFileCrawlingVisitorTest {
    private static APFS apfs;
    private static ApfsFileCrawlingVisitor visitor;

    private String[] fileNames(LinkedList<ApfsFile> files){
        String[] fileNames = new String[files.size()];
        for (int i = 0; i < files.size(); i++){
            fileNames[i] = files.get(i).getName();
        }
        return fileNames;
    }

    @BeforeAll
    public static void setUpFS(){
        // Initialize file system fixture and count files with Visitor
        apfs = ApfsFixtureInitializer.createAPFS();
        visitor = new ApfsFileCrawlingVisitor();
        ApfsElement root = (ApfsElement) apfs.getRootDirs().getFirst();
        root.accept(visitor);
    }

    @Test
    public void verifyFileQuantity(){ assertEquals(6, visitor.getFiles().size()); }

    @Test
    public void verifyFoundFileNames(){
        String[] expected = {"a", "c", "d", "e", "f", "b"};
        String[] actual = fileNames(visitor.getFiles());
        assertArrayEquals(expected, actual);
    }

}