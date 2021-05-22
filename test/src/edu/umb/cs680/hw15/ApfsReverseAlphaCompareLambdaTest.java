package edu.umb.cs680.hw15.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsReverseAlphaLambdaCompareLambdaTest {
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
    public void verifySubDirRootReverseAlphaLambda(){
        String[] expected = {"home", "applications"};
        assertArrayEquals(expected, dirArray(root.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) ->
                    {return elem2.getName().compareTo(elem1.getName());}
        )));
    }

    @Test
    public void verifySubDirApplicationsReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(applications.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifySubDirHomeReverseAlphaLambda(){
        String[] expected = {"pics", "code"};
        assertArrayEquals(expected, dirArray(home.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifySubDirCodeReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(code.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifySubDirPicsReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, dirArray(pics.getSubDirectories(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyFileContentRootReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, fileArray(root.getFiles(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyFileContentApplicationsReverseAlphaLambda(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileArray(applications.getFiles(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyFileContentHomeReverseAlphaLambda(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileArray(home.getFiles(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyFileContentCodeReverseAlphaLambda(){
        String[] expected = {"d", "c"};
        assertArrayEquals(expected, fileArray(code.getFiles(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyFileContentPicsReverseAlphaLambda(){
        String[] expected = {"f", "e"};
        assertArrayEquals(expected, fileArray(pics.getFiles(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyGetChildrenRootReverseAlphaLambda(){
        String[] expected = {"home", "applications"};
        assertArrayEquals(expected, elemArray(root.getChildren(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyGetChildrenApplicationsReverseAlphaLambda(){
        String[] expected = {"a"};
        assertArrayEquals(expected, elemArray(applications.getChildren(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyGetChildrenHomeReverseAlphaLambda(){
        String[] expected = {"x", "w", "pics", "code", "b"};
        assertArrayEquals(expected, elemArray(home.getChildren(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyGetChildrenCodeReverseAlphaLambda(){
        String[] expected = {"z", "y", "d", "c"};
        assertArrayEquals(expected, elemArray(code.getChildren(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyGetChildrenPicsReverseAlphaLambda(){
        String[] expected = {"f", "e"};
        assertArrayEquals(expected, elemArray(pics.getChildren(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyLinkContentRootReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(root.getLinks(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyLinkContentApplicationsReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(applications.getLinks(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyLinkContentHomeReverseAlphaLambda(){
        String[] expected = {"x", "w"};
        assertArrayEquals(expected, linkArray(home.getLinks(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyLinkContentCodeReverseAlphaLambda(){
        String[] expected = {"z", "y"};
        assertArrayEquals(expected, linkArray(code.getLinks(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

    @Test
    public void verifyLinkContentPicsReverseAlphaLambda(){
        String[] expected = {};
        assertArrayEquals(expected, linkArray(pics.getLinks(
                (ApfsElement elem1, ApfsElement elem2) ->
                {return elem2.getName().compareTo(elem1.getName());}
                )));
    }

}