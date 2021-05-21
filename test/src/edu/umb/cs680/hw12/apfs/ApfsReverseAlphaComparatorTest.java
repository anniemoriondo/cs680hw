package edu.umb.cs680.hw12.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsReverseAlphaComparatorTest {
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
    public void verifySubDirRootReverseAlpha(){
        String[] expected = {"home", "applications"};
        assertArrayEquals(expected, dirArray(root.getSubDirectories(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifySubDirApplicationsReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(applications.getSubDirectories(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifySubDirHomeReverseAlpha(){
        String[] expected = {"pics", "code"};
        assertArrayEquals(expected, dirArray(home.getSubDirectories(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifySubDirCodeReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(code.getSubDirectories(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifySubDirPicsReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(pics.getSubDirectories(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyFileContentRootReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, fileArray(root.getFiles(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyFileContentApplicationsReverseAlpha(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileArray(applications.getFiles(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyFileContentHomeReverseAlpha(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileArray(home.getFiles(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyFileContentCodeReverseAlpha(){
        String[] expected = {"d", "c"};
        assertArrayEquals(expected, fileArray(code.getFiles(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyFileContentPicsReverseAlpha(){
        String[] expected = {"f", "e"};
        assertArrayEquals(expected, fileArray(pics.getFiles(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyGetChildrenRootReverseAlpha(){
        String[] expected = {"home", "applications"};
        assertArrayEquals(expected, elemArray(root.getChildren(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyGetChildrenApplicationsReverseAlpha(){
        String[] expected = {"a"};
        assertArrayEquals(expected, elemArray(applications.getChildren(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyGetChildrenHomeReverseAlpha(){
        String[] expected = {"x", "w", "pics", "code", "b"};
        assertArrayEquals(expected, elemArray(home.getChildren(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyGetChildrenCodeReverseAlpha(){
        String[] expected = {"z", "y", "d", "c"};
        assertArrayEquals(expected, elemArray(code.getChildren(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyGetChildrenPicsReverseAlpha(){
        String[] expected = {"f", "e"};
        assertArrayEquals(expected, elemArray(pics.getChildren(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyLinkContentRootReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(root.getLinks(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyLinkContentApplicationsReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(applications.getLinks(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyLinkContentHomeReverseAlpha(){
        String[] expected = {"x", "w"};
        assertArrayEquals(expected, linkArray(home.getLinks(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyLinkContentCodeReverseAlpha(){
        String[] expected = {"z", "y"};
        assertArrayEquals(expected, linkArray(code.getLinks(
                new ApfsReverseAlphaComparator())));
    }

    @Test
    public void verifyLinkContentPicsReverseAlpha(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(pics.getLinks(
                new ApfsReverseAlphaComparator())));
    }

}