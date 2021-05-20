package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    private TestFixtureInitializer(){}

    public static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root", LocalDateTime.now());
        fs.appendRootDir(root);

        Directory applications = new Directory(root, "applications",
                LocalDateTime.now());
        Directory home = new Directory(root, "home", LocalDateTime.now());
        Directory code = new Directory(home, "code", LocalDateTime.now());
        Directory pics = new Directory(home, "pics", LocalDateTime.now());

        File a = new File(applications, "a", 100, LocalDateTime.now());
        File b = new File(home, "b", 200, LocalDateTime.now());
        File c = new File(code, "c", 300, LocalDateTime.now());
        File d = new File(code, "d", 400, LocalDateTime.now());
        File e = new File(code, "e", 500, LocalDateTime.now());
        File f = new File(code, "f", 600, LocalDateTime.now());

        return fs;
    }

    public static void main(String[] args){
        System.out.println(createFS().getRootDirs().size());
    }
}