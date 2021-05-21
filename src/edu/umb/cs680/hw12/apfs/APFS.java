package edu.umb.cs680.hw12.apfs;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {


    public FSElement createDefaultRoot() {
        ApfsDirectory root = new ApfsDirectory(null, "root", LocalDateTime.now(),
                "Admin", LocalDateTime.now());
        return (FSElement) root;
    }

    public void setRoot(FSElement newRoot){
        if (this.getRootDirs().size() == 0){
            super.setRoot(newRoot);
        } else {
            System.out.println("APFS can only have one root.");
        }
    }
}
