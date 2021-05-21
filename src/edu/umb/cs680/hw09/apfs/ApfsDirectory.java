package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;
import java.time.LocalDateTime;
import java.util.LinkedList;


public class ApfsDirectory extends ApfsElement {
    private LinkedList<ApfsElement> children = new LinkedList<>();

    public ApfsDirectory(ApfsDirectory parent, String name, LocalDateTime creationTime){
        // File size of ApfsDirectory is always 0
        super(parent, name, 0, creationTime);
        if (parent != null){ parent.appendChild(this); }
    }

    public LinkedList<ApfsElement> getChildren(){
        return this.children;
    }

    public void appendChild(ApfsElement newChild){
        this.children.add(newChild);
    }

    public int countChildren(){
        return this.children.size();
    }

    public boolean isDirectory() { return true; }

    public boolean isLink() { return false; }

    /**
     * Gets all directories immediately inside this ApfsDirectory
     * @return LinkedList of all children which are Directories
     */
    public LinkedList<ApfsDirectory> getSubDirectories(){
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<>();
        for (ApfsElement thisElem : this.children){
            if (thisElem.isDirectory()){
                subDirectories.add((ApfsDirectory) thisElem);
            }
        }
        return subDirectories;
    }

    /**
     * Gets all files immediately inside this ApfsDirectory
     * @return LinkedList of all children which are Files
     */
    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (edu.umb.cs680.hw09.fs.FSElement thisElem : this.children){
            if (!thisElem.isDirectory() && !thisElem.isLink()){
                files.add((ApfsFile) thisElem);
            }
        }
        return files;
    }

    /**
     * Gets all links immediately inside this ApfsDirectory
     * @return LinkedList of all children which are Links
     */
    public LinkedList<ApfsLink> getLinks(){
        LinkedList<ApfsLink> links = new LinkedList<>();
        for (edu.umb.cs680.hw09.fs.FSElement thisElem : this.children){
            if (thisElem.isLink()){
                links.add((ApfsLink) thisElem);
            }
        }
        return links;
    }

    /**
     * Recursively gets size of ApfsDirectory and all subdirectories/their files.
     * @return int representing total ApfsDirectory size
     */
    public int getSize(){
        int totalSize = 0;
        for (FSElement thisChild : this.getChildren()){
            if (thisChild.isDirectory()){
                totalSize += ((ApfsDirectory) thisChild).getSize();
            } else {
                totalSize += thisChild.getSize();
            }
        }
        return totalSize;
    }

    public static void main(String[] args){
        ApfsDirectory myDir = new ApfsDirectory(null, "Annie", LocalDateTime.now());
        System.out.println(myDir.getName());
        System.out.println(myDir.isLink());
    }
}
