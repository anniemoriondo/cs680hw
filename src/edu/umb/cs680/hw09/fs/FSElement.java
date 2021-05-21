package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.Directory;

import java.time.LocalDateTime;


public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private FSElement parent;

    public FSElement(FSElement parent, String name, int size,
                     LocalDateTime creationTime) throws Exception {
        // Can't use a parent that is not a directory (file or link)
        if(parent != null && !parent.isDirectory()){
            throw new Exception("Parent must be a directory");
        }
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    // Getters
    public FSElement getParent(){ return this.parent; }

    public String getName(){ return this.name; }

    public LocalDateTime getCreationTime(){ return this.creationTime; }

    public int getSize(){ return this.size; }

    // Setters
    public void setParent(Directory newParent){ this.parent = newParent; }

    public void setName(String newName){ this.name = newName; }

    public void setCreationTime(LocalDateTime newTime){
        this.creationTime = newTime;}

    public void setSize(int newSize){ this.size = newSize;}

    // Booleans - we need to know if this is a directory or a link
    public abstract boolean isDirectory();

    public abstract boolean isLink();

}
