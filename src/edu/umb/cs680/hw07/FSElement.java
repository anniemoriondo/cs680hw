package edu.umb.cs680.hw07;

import java.time.LocalDateTime;


public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size,
                     LocalDateTime creationTime){
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    // Getters
    public Directory getParent(){ return this.parent; }

    public String getName(){ return this.name; }

    public LocalDateTime getCreationTime(){ return this.creationTime; }

    public int getSize(){ return this.size; }

    // Setters
    public void setParent(Directory newParent){ this.parent = newParent; }

    public void setName(String newName){ this.name = newName; }

    public void setCreationTime(LocalDateTime newTime){
        this.creationTime = newTime;}

    public void setSize(int newSize){ this.size = newSize;}

    public abstract boolean isDirectory();

}
