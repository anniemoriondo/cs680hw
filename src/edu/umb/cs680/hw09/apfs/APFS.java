package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {


    public FSElement createDefaultRoot() {
        ApfsDirectory root = new ApfsDirectory(null, "root", LocalDateTime.now());
        return (FSElement) root;
    }
}
