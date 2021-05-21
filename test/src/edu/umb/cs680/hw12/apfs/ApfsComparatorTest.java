package edu.umb.cs680.hw12.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsComparatorTest {
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
    public void verifySubDirRootDefaultOrder(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, dirArray(root.getSubDirectories()));
    }

    @Test
    public void verifySubDirApplicationsDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(applications.getSubDirectories()));
    }

    @Test
    public void verifySubDirHomeDefaultOrder(){
        String[] expected = {"code", "pics"};
        assertArrayEquals(expected, dirArray(home.getSubDirectories()));
    }

    @Test
    public void verifySubDirCodeDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(code.getSubDirectories()));
    }

    @Test
    public void verifySubDirPicsDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(pics.getSubDirectories()));
    }

    @Test
    public void verifyFileContentRootDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, fileArray(root.getFiles()));
    }

    @Test
    public void verifyFileContentApplicationsDefaultOrder(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileArray(applications.getFiles()));
    }

    @Test
    public void verifyFileContentHomeDefaultOrder(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileArray(home.getFiles()));
    }

    @Test
    public void verifyFileContentCodeDefaultOrder(){
        String[] expected = {"c", "d"};
        assertArrayEquals(expected, fileArray(code.getFiles()));
    }

    @Test
    public void verifyFileContentPicsDefaultOrder(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, fileArray(pics.getFiles()));
    }

    @Test
    public void verifyGetChildrenRootDefaultOrder(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, elemArray(root.getChildren()));
    }

    @Test
    public void verifyGetChildrenApplicationsDefaultOrder(){
        String[] expected = {"a"};
        assertArrayEquals(expected, elemArray(applications.getChildren()));
    }

    @Test
    public void verifyGetChildrenHomeDefaultOrder(){
        String[] expected = {"b", "code", "pics", "w", "x"};
        assertArrayEquals(expected, elemArray(home.getChildren()));
    }

    @Test
    public void verifyGetChildrenCodeDefaultOrder(){
        String[] expected = {"c", "d", "y", "z"};
        assertArrayEquals(expected, elemArray(code.getChildren()));
    }

    @Test
    public void verifyGetChildrenPicsDefaultOrder(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, elemArray(pics.getChildren()));
    }

    @Test
    public void verifyLinkContentRootDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(root.getLinks()));
    }

    @Test
    public void verifyLinkContentApplicationsDefaultOrder(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(applications.getLinks()));
    }

    @Test
    public void verifyLinkContentHomeDefaultOrder(){
        String[] expected = {"w", "x"};
        assertArrayEquals(expected, linkArray(home.getLinks()));
    }

    @Test
    public void verifyLinkContentCodeDefaultOrder(){
        String[] expected = {"y", "z"};
        assertArrayEquals(expected, linkArray(code.getLinks()));
    }

    @Test
    public void verifyLinkContentPics(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(pics.getLinks()));
    }

}