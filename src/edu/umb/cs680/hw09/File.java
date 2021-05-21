package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File (ApfsDirectory parent, String name, int size,
                 LocalDateTime creationTime){
        super(parent, name, size, creationTime);
        parent.appendChild(this);
    }

    public boolean isDirectory() { return false; }

    public boolean isLink() { return false; }
}