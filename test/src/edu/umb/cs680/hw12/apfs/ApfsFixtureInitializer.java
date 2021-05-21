package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;

public class ApfsFixtureInitializer {

    /**
     * Preps an APFS tree for testing.
     * @return A sample APFS tree
     */
    public static APFS createAPFS(){
        APFS apfs = new APFS();
        apfs.initFileSystem("Sample APFS", 250000);

        LocalDateTime createTime = LocalDateTime.now();
        String ownerName = "Annie";
        LocalDateTime modifiedTime = LocalDateTime.now();

        ApfsDirectory root = (ApfsDirectory) apfs.getRootDirs().getFirst();
        ApfsDirectory applications = new ApfsDirectory(root, "applications",
                createTime, ownerName, modifiedTime);
        ApfsDirectory home = new ApfsDirectory(root, "home",
                createTime, ownerName, modifiedTime);
        ApfsDirectory pics = new ApfsDirectory(home, "pics",
                createTime, ownerName, modifiedTime);
        ApfsDirectory code = new ApfsDirectory(home, "code",
                createTime, ownerName, modifiedTime);

        ApfsFile a = new ApfsFile(applications, "a", 100,
                createTime, ownerName, modifiedTime);
        ApfsFile b = new ApfsFile(home, "b", 200,
                createTime, ownerName, modifiedTime);
        ApfsFile d = new ApfsFile(code, "d", 400,
                createTime, ownerName, modifiedTime);
        ApfsFile e = new ApfsFile(pics, "e", 500,
                createTime, ownerName, modifiedTime);
        ApfsFile f = new ApfsFile(pics, "f", 600,
                createTime, ownerName, modifiedTime);
        ApfsFile c = new ApfsFile(code, "c", 300,
                createTime, ownerName, modifiedTime);

        ApfsLink w = new ApfsLink(home, "w", createTime, c,
                ownerName, modifiedTime);
        ApfsLink x = new ApfsLink(home, "x", createTime, applications,
                ownerName, modifiedTime);
        ApfsLink z = new ApfsLink(code, "z", createTime, b,
                ownerName, modifiedTime);
        ApfsLink y = new ApfsLink(code, "y", createTime, a,
                ownerName, modifiedTime);


        return apfs;
    }
}