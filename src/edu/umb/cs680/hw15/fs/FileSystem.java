package edu.umb.cs680.hw15.fs;
// From Notes 13

import java.util.LinkedList;

public abstract class FileSystem {
    private String name;
    private int capacity;
    private int id;

    LinkedList<FSElement> rootDirs = new LinkedList<>();

    public FSElement initFileSystem(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();

        // If the default root of this file system is valid, return it.
        if (root.isDirectory() && capacity >= root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            // If we reach here, that's the file system subclass's fault.
            return null;
        }
    }
    public abstract FSElement createDefaultRoot();

    public void setRoot(FSElement root){ rootDirs.add(root); }

    // Getters
    public int getCapacity(){return this.capacity;}

    public String getName(){return this.name;}

    public int getId(){return this.id;}

    public LinkedList<FSElement> getRootDirs() { return rootDirs; }

    // Returns total size of all files in this file system.
    public int getUsed(){
        int total = 0;
        for (FSElement thisRoot : rootDirs){
            total += thisRoot.getSize();
        }
        return total;
    }



}
