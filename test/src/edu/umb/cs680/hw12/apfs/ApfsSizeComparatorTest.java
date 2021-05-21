package edu.umb.cs680.hw12.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsSizeComparatorTest {
    // Instance variables from our test fixture.
    private static APFS apfs;
    private static ApfsDirectory root;
    private static ApfsDirectory home;
    private static ApfsDirectory applications;
    private static ApfsDirectory code;
    private static ApfsDirectory pics;
    

    /**
     * Generates a string array from a linked list of elements.
     * @param list a linked list of ApfsElements
     * @return An array of all element names as Strings
     */
    private String[] elemArray(LinkedList<ApfsElement> list){
        String[] names = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            names[i] = list.get(i).getName();
        }
        return names;
    }

     //As above, but for directories
    private String[] dirArray(LinkedList<ApfsDirectory> list){
        String[] names = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            names[i] = list.get(i).getName();
        }
        return names;
    }

    // As above, but for files
    private String[] fileArray(LinkedList<ApfsFile> list){
        String[] names = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            names[i] = list.get(i).getName();
        }
        return names;
    }

    // As above, but for links
    private String[] linkArray(LinkedList<ApfsLink> list){
        String[] names = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            names[i] = list.get(i).getName();
        }
        return names;
    }

    @BeforeAll
    public static void setUpFS(){
        apfs = ApfsFixtureInitializer.createAPFS();
        root = (ApfsDirectory) apfs.getRootDirs().get(0);
        applications = (ApfsDirectory) root.getChildren().get(0);
        home = (ApfsDirectory) root.getChildren().get(1);
        code = (ApfsDirectory) home.getChildren().get(1);
        pics = (ApfsDirectory) home.getChildren().get(2);
    }


    @Test
    public void verifySubDirRootBySize(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, dirArray(root.getSubDirectories(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifySubDirApplicationsBySize(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(applications.getSubDirectories(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifySubDirHomeBySize(){
        String[] expected = {"code", "pics"};
        assertArrayEquals(expected, dirArray(home.getSubDirectories(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifySubDirCodeBySize(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(code.getSubDirectories(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifySubDirPicsBySize(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(pics.getSubDirectories(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyFileContentRootBySize(){
        String[] expected = {};
        assertArrayEquals(expected, fileArray(root.getFiles(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyFileContentApplicationsBySize(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileArray(applications.getFiles(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyFileContentHomeBySize(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileArray(home.getFiles(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyFileContentCodeBySize(){
        String[] expected = {"c", "d"};
        assertArrayEquals(expected, fileArray(code.getFiles(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyFileContentPicsBySize(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, fileArray(pics.getFiles(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyGetChildrenRootBySize(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, elemArray(root.getChildren(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyGetChildrenApplicationsBySize(){
        String[] expected = {"a"};
        assertArrayEquals(expected, elemArray(applications.getChildren(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyGetChildrenHomeBySize(){
        String[] expected = {"w", "x", "b", "code", "pics"};
        assertArrayEquals(expected, elemArray(home.getChildren(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyGetChildrenCodeBySize(){
        String[] expected = {"y", "z", "c", "d"};
        assertArrayEquals(expected, elemArray(code.getChildren(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyGetChildrenPicsBySize(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, elemArray(pics.getChildren(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyLinkContentRootBySize(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(root.getLinks(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyLinkContentApplicationsBySize(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(applications.getLinks(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyLinkContentHomeBySize(){
        // Links all have size 0 so default ordering applies
        String[] expected = {"w", "x"};
        assertArrayEquals(expected, linkArray(home.getLinks(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyLinkContentCodeBySize(){
        String[] expected = {"y", "z"};
        assertArrayEquals(expected, linkArray(code.getLinks(
                new ApfsSizeComparator())));
    }

    @Test
    public void verifyLinkContentPicsBySize(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(pics.getLinks(
                new ApfsSizeComparator())));
    }

}