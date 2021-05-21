package edu.umb.cs680.hw09.apfs;


import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

    public ApfsFile (ApfsDirectory parent, String name, int size,
                 LocalDateTime creationTime){
        super(parent, name, size, creationTime);
        parent.appendChild(this);
    }

    public boolean isDirectory() { return false; }

    public boolean isLink() { return false; }
}
