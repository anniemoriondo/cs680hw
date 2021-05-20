package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, LocalDateTime creationTime){
        // File size of directory is always 0
        super(parent, name, 0, creationTime);
        if (parent != null){ parent.appendChild(this); }
    }

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild(FSElement newChild){
        this.children.add(newChild);
    }

    public int countChildren(){
        return this.children.size();
    }

    public boolean isDirectory() {
        return true;
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDirectories = new LinkedList<>();
        for (FSElement thisElem : this.children){
            if (thisElem.isDirectory()){
                subDirectories.add((Directory) thisElem);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> files = new LinkedList<>();
        for (FSElement thisElem : this.children){
            if (! thisElem.isDirectory()){
                files.add((File) thisElem);
            }
        }
        return files;
    }

    public int getTotalSize(){
        int totalSize = 0;
        for (File thisFile : this.getFiles()){
            totalSize += thisFile.getSize();
        }
        return totalSize;
    }

    public static void main(String[] args){
        Directory myDir = new Directory(null, "Annie", LocalDateTime.now());
        System.out.println(myDir.getName());
    }
}
