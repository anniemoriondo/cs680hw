package edu.umb.cs680.hw15.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsSizeCompareLambdaTest {
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

    // Test calling getSubDirectories() by passing a lambda expression.
    // Sorting by directory total size.

    @Test
    public void verifySubDirRootBySizeLambda(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, dirArray(root.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                }
                )));
    }

    @Test
    public void verifySubDirApplicationsBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(applications.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifySubDirHomeBySizeLambda(){
        String[] expected = {"code", "pics"};
        assertArrayEquals(expected, dirArray(home.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) -> {
                    int elem1size = elem1.isDirectory() ?
                            ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifySubDirCodeBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(code.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) -> {
                    int elem1size = elem1.isDirectory() ?
                            ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifySubDirPicsBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(pics.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    // Test calling getFiles() by passing a lambda expression. Sorting by size.

    @Test
    public void verifyFileContentRootBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, fileArray(root.getFiles(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyFileContentApplicationsBySizeLambda(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileArray(applications.getFiles(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyFileContentHomeBySizeLambda(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileArray(home.getFiles(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyFileContentCodeBySizeLambda(){
        String[] expected = {"c", "d"};
        assertArrayEquals(expected, fileArray(code.getFiles(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyFileContentPicsBySizeLambda(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, fileArray(pics.getFiles(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    // Test calling getChildren() by passing a lambda expression.
    // Sorting by directory total size and file/link individual size.

    @Test
    public void verifyGetChildrenRootBySizeLambda(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, elemArray(root.getChildren(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyGetChildrenApplicationsBySizeLambda(){
        String[] expected = {"a"};
        assertArrayEquals(expected, elemArray(applications.getChildren(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyGetChildrenHomeBySizeLambda(){
        String[] expected = {"w", "x", "b", "code", "pics"};
        assertArrayEquals(expected, elemArray(home.getChildren(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyGetChildrenCodeBySizeLambda(){
        String[] expected = {"y", "z", "c", "d"};
        assertArrayEquals(expected, elemArray(code.getChildren(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyGetChildrenPicsBySizeLambda(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, elemArray(pics.getChildren(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    // Test calling getLinks() by passing a lambda expression.
    // Sorting by size, but all links have size 0 so default sort is used.

    @Test
    public void verifyLinkContentRootBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(root.getLinks(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyLinkContentApplicationsBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(applications.getLinks(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyLinkContentHomeBySizeLambda(){
        // Links all have size 0 so default ordering applies
        String[] expected = {"w", "x"};
        assertArrayEquals(expected, linkArray(home.getLinks(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyLinkContentCodeBySizeLambda(){
        String[] expected = {"y", "z"};
        assertArrayEquals(expected, linkArray(code.getLinks(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

    @Test
    public void verifyLinkContentPicsBySizeLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(pics.getLinks(
                (ApfsElement elem1, ApfsElement elem2) -> { 
                    int elem1size = elem1.isDirectory() ?
                        ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
                    int elem2size = elem2.isDirectory() ?
                            ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
                    return elem1size - elem2size;
                })));
    }

}