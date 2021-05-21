package edu.umb.cs680.hw09.apfs;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class ApfsDirectoryTest {
    // Instance variables from our test fixture.
    private static APFS apfs;
    private static ApfsDirectory root;
    private static ApfsDirectory home;
    private static ApfsDirectory applications;
    private static ApfsDirectory code;
    private static ApfsDirectory pics;

    /**
     * Represents a directory as a string array.
     * @param d a directory
     * @return an array with all the details of that directory as Strings
     */
    private String[] dirToStringArray(ApfsDirectory d){
        String parentName = d.getParent() == null ?
                "null" : d.getParent().getName();

        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                String.valueOf(d.isLink()),
                d.getName(),
                String.valueOf(d.getSize()),
                parentName,
                String.valueOf(d.countChildren()),
                d.getOwnerName()};
        return dirInfo;
    }

    /**
     * Lists all subdirectories of a directory.
     * @param d a directory
     * @return An array of all subdirectory names as Strings
     */
    private String[] subdirList(ApfsDirectory d){
        LinkedList<ApfsDirectory> subDirs = d.getSubDirectories();
        String[] subdirNames = new String[subDirs.size()];
        for (int i = 0; i < subDirs.size(); i++){
            subdirNames[i] = subDirs.get(i).getName();
        }
        return subdirNames;
    }

    /**
     * Lists all files directly inside a directory.
     * @param d a directory
     * @return An array of all child file names as Strings
     */
    private String[] fileList(ApfsDirectory d){
        LinkedList<ApfsFile> fileContents = d.getFiles();
        String[] fileNames = new String[fileContents.size()];
        for (int i = 0; i < fileContents.size(); i++){
            fileNames[i] = fileContents.get(i).getName();
        }
        return fileNames;
    }

    private String[] linksList(ApfsDirectory d){
        LinkedList<ApfsLink> links = d.getLinks();
        String[] linkNames = new String[links.size()];
        for (int i = 0; i < links.size(); i++){
            linkNames[i] = links.get(i).getName();
        }
        return linkNames;
    }

    @BeforeAll
    public static void setUpFS(){
        apfs = ApfsFixtureInitializer.createAPFS();
        root = (ApfsDirectory) apfs.getRootDirs().get(0);
        applications = (ApfsDirectory) root.getChildren().get(0);
        home = (ApfsDirectory) root.getChildren().get(1);
        code = (ApfsDirectory) home.getChildren().get(0);
        pics = (ApfsDirectory) home.getChildren().get(1);
    }

    @Test
    public void verifyDirectoryEqualityRoot(){
        // Root always is owned by Admin
        String[] expected = {"true", "false", "root", "0", "null", "2", "Admin"};
        assertArrayEquals(expected, dirToStringArray(root));

    }

    @Test
    public void verifyDirectoryEqualityApplications(){
        String[] expected = {"true", "false", "applications", "0", "root", "1", "Annie"};
        assertArrayEquals(expected, dirToStringArray(applications));
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"true", "false", "home", "0", "root", "4", "Annie"};
        assertArrayEquals(expected, dirToStringArray(home));
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"true", "false", "code", "0", "home", "3", "Annie"};
        assertArrayEquals(expected, dirToStringArray(code));
    }

    @Test
    public void verifyDirectoryEqualityPics(){
        String[] expected = {"true", "false", "pics", "0", "home", "2", "Annie"};
        assertArrayEquals(expected, dirToStringArray(pics));
    }


    @Test
    public void verifySubDirRoot(){
        String[] expected = {"applications", "home"};
        assertArrayEquals(expected, subdirList(root));
    }

    @Test
    public void verifySubDirApplications(){
        String[] expected = {};
        assertArrayEquals(expected, subdirList(applications));
    }

    @Test
    public void verifySubDirHome(){
        String[] expected = {"code", "pics"};
        assertArrayEquals(expected, subdirList(home));
    }

    @Test
    public void verifySubDirCode(){
        String[] expected = {};
        assertArrayEquals(expected, subdirList(code));
    }

    @Test
    public void verifySubDirPics(){
        String[] expected = {};
        assertArrayEquals(expected, subdirList(pics));
    }

    @Test
    public void verifyFileContentRoot(){
        String[] expected = {};
        assertArrayEquals(expected, fileList(root));
    }

    @Test
    public void verifyFileContentApplications(){
        String[] expected = {"a"};
        assertArrayEquals(expected, fileList(applications));
    }

    @Test
    public void verifyFileContentHome(){
        String[] expected = {"b"};
        assertArrayEquals(expected, fileList(home));
    }

    @Test
    public void verifyFileContentCode(){
        String[] expected = {"c", "d"};
        assertArrayEquals(expected, fileList(code));
    }

    @Test
    public void verifyFileContentPics(){
        String[] expected = {"e", "f"};
        assertArrayEquals(expected, fileList(pics));
    }

    @Test
    public void verifyTotalSizeRoot(){
        int expected = 2100;
        assertEquals(expected, root.getTotalSize());
    }

    @Test
    public void verifyTotalSizeApplications(){
        int expected = 100;
        assertEquals(expected, applications.getTotalSize());
    }

    @Test
    public void verifyTotalSizeHome(){
        int expected = 2000;
        assertEquals(expected, home.getTotalSize());
    }

    @Test
    public void verifyTotalSizeCode(){
        int expected = 700;
        assertEquals(expected, code.getTotalSize());
    }

    @Test
    public void verifyTotalSizePics(){
        int expected = 1100;
        assertEquals(expected, pics.getTotalSize());
    }

    @Test
    public void verifyLinkContentRoot(){
        String[] expected = {};
        assertArrayEquals(expected, linksList(root));
    }

    @Test
    public void verifyLinkContentApplications(){
        String[] expected = {};
        assertArrayEquals(expected, linksList(applications));
    }

    @Test
    public void verifyLinkContentHome(){
        String[] expected = {"x"};
        assertArrayEquals(expected, linksList(home));
    }

    @Test
    public void verifyLinkContentCode(){
        String[] expected = {"y"};
        assertArrayEquals(expected, linksList(code));
    }

    @Test
    public void verifyLinkContentPics(){
        String[] expected = {};
        assertArrayEquals(expected, linksList(pics));
    }

}