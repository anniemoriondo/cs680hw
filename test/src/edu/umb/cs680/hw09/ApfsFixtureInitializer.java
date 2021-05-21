package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

public class ApfsFixtureInitializer {

    public static APFS createAPFS(){
        APFS apfs = ApfsFileSystem.getApfsFileSystem();
        apfs.initApfsFileSystem();
        
        ApfsDirectory root = (ApfsDirectory) apfs.getRootDirs().getFirst();
        ApfsDirectory applications = new ApfsDirectory(root, "applications",
                    LocalDateTime.now());
        ApfsDirectory home = new ApfsDirectory(root, "home", LocalDateTime.now());
        ApfsDirectory code = new ApfsDirectory(home, "code", LocalDateTime.now());
        ApfsDirectory pics = new ApfsDirectory(home, "pics", LocalDateTime.now());

        ApfsFile a = new ApfsFile(applications, "a", 100, LocalDateTime.now());
        ApfsFile b = new ApfsFile(home, "b", 200, LocalDateTime.now());
        ApfsFile c = new ApfsFile(code, "c", 300, LocalDateTime.now());
        ApfsFile d = new ApfsFile(code, "d", 400, LocalDateTime.now());
        ApfsFile e = new ApfsFile(pics, "e", 500, LocalDateTime.now());
        ApfsFile f = new ApfsFile(pics, "f", 600, LocalDateTime.now());

        ApfsLink x = new ApfsLink(home, "x", LocalDateTime.now(), applications);
        ApfsLink y = new ApfsLink(code, "y", LocalDateTime.now(), a);

        return fs;
    }
}