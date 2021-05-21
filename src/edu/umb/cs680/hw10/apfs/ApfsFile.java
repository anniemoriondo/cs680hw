package edu.umb.cs680.hw10.apfs;


import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

    public ApfsFile (ApfsDirectory parent, String name, int size,
                     LocalDateTime creationTime, String ownerName,
                     LocalDateTime modified){
        super(parent, name, size, creationTime, ownerName, modified);
        parent.appendChild(this);
    }

    public boolean isDirectory() { return false; }

    public boolean isLink() { return false; }

    // Accept a visitor
    public void accept(ApfsVisitor v){v.visit(this);}
}
