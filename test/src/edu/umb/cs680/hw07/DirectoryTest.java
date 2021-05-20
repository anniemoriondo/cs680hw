package edu.umb.cs680.hw07;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class DirectoryTest {
    // Instance variables from our test fixture.
    private static FileSystem fs;
    private static Directory root;
    private static Directory home;
    private static Directory applications;
    private static Directory code;
    private static Directory pics;

    private String[] dirToStringArray(Directory d){
        String parentName = d.getParent() == null ?
                "null" : d.getParent().getName();

        String[] dirInfo = {
                String.valueOf(d.isDirectory()),
                d.getName(),
                String.valueOf(d.getSize()),
                //d.getCreationTime().toString(),
                parentName,
                String.valueOf(d.countChildren())
        };
        return dirInfo;
    }

    private String[] subdirList(Directory d){
        LinkedList<Directory> subDirs = d.getSubDirectories();
        String[] subdirNames = new String[subDirs.size()];
        for (int i = 0; i < subDirs.size(); i++){
            subdirNames[i] = subDirs.get(i).getName();
        }
        return subdirNames;
    }

    private String[] fileList(Directory d){
        LinkedList<File> fileContents = d.getFiles();
        String[] fileNames = new String[fileContents.size()];
        for (int i = 0; i < fileContents.size(); i++){
            fileNames[i] = fileContents.get(i).getName();
        }
        return fileNames;
    }

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirs().get(0);
        applications = (Directory) root.getChildren().get(0);
        home = (Directory) root.getChildren().get(1);
        code = (Directory) home.getChildren().get(0);
        pics = (Directory) home.getChildren().get(1);
    }

    @Test
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"true", "root", "0", "null", "2"};
        assertArrayEquals(expected, dirToStringArray(root));

    }

    @Test
    public void verifyDirectoryEqualityApplications(){
        String[] expected = {"true", "applications", "0", "root", "1"};
        assertArrayEquals(expected, dirToStringArray(applications));
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"true", "home", "0", "root", "3"};
        assertArrayEquals(expected, dirToStringArray(home));
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"true", "code", "0", "home", "2"};
        assertArrayEquals(expected, dirToStringArray(code));
    }

    @Test
    public void verifyDirectoryEqualityPics(){
        String[] expected = {"true", "pics", "0", "home", "2"};
        assertArrayEquals(expected, dirToStringArray(pics));
    }

    @Test
    public void verifyCountChildrenRoot(){
        assertEquals(2, root.countChildren());
    }

    @Test
    public void verifyCountChildrenApplications(){
        assertEquals(1, applications.countChildren());
    }

    @Test
    public void verifyCountChildrenHome(){
        assertEquals(3, home.countChildren());
    }

    @Test
    public void verifyCountChildrenCode(){
        assertEquals(2, code.countChildren());
    }

    @Test
    public void verifyCountChildrenPics(){
        assertEquals(2, pics.countChildren());
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

}