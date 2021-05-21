package edu.umb.cs680.hw12.apfs;

import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class ApfsDirectory extends ApfsElement {
    private LinkedList<ApfsElement> children = new LinkedList<>();

    public ApfsDirectory(ApfsDirectory parent, String name, LocalDateTime creationTime,
                         String ownerName, LocalDateTime modified){
        // File size of ApfsDirectory is always 0
        super(parent, name, 0, creationTime, ownerName, modified);
        if (parent != null){ parent.appendChild(this); }
    }

    public LinkedList<ApfsElement> getChildren(){
        // Default ordering is alphabetical; we'll keep this ordering.
        Collections.sort(this.children, new ApfsComparator());
        return this.children;
    }

    // getChildren with custom comparator
    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator){
        LinkedList<ApfsElement> temp = new LinkedList<>(this.children);
        Collections.sort(temp, comparator);
        return temp;
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
        Collections.sort(subDirectories, new ApfsComparator());
        return subDirectories;
    }

    /**
     * Gets all subdirectories and custom sorts them
     * @param comparator a custom ApfsElement comparator
     * @return a list of custom sorted subdirectories
     */
    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator){
        LinkedList<ApfsDirectory> subDirectories = this.getSubDirectories();
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }

    /**
     * Gets all files immediately inside this ApfsDirectory
     * @return LinkedList of all children which are Files
     */
    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (FSElement thisElem : this.children){
            if (!thisElem.isDirectory() && !thisElem.isLink()){
                files.add((ApfsFile) thisElem);
            }
        }
        Collections.sort(files, new ApfsComparator());
        return files;
    }

    /**
     * Gets all files immediately inside this ApfsDirectory, custom sorted
     * @param comparator a custom ApfsElement comparator
     * @return LinkedList of all children which are Files
     */
    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator){
        LinkedList<ApfsFile> files = this.getFiles();
        Collections.sort(files, comparator);
        return files;
    }

    /**
     * Gets all links immediately inside this ApfsDirectory
     * @return LinkedList of all children which are Links
     */
    public LinkedList<ApfsLink> getLinks(){
        LinkedList<ApfsLink> links = new LinkedList<>();
        for (FSElement thisElem : this.children){
            if (thisElem.isLink()){
                links.add((ApfsLink) thisElem);
            }
        }
        Collections.sort(links, new ApfsComparator());
        return links;
    }

    public LinkedList<ApfsLink> getLinks(Comparator<ApfsElement> comparator){
        LinkedList<ApfsLink> links = this.getLinks();
        Collections.sort(links, comparator);
        return links;
    }

    /**
     * Recursively gets size of ApfsDirectory and all subdirectories/their files.
     * @return int representing total ApfsDirectory size
     */
    public int getTotalSize(){
        int totalSize = 0;
        for (FSElement thisChild : this.getChildren()){
            if (thisChild.isDirectory()){
                totalSize += ((ApfsDirectory) thisChild).getTotalSize();
            } else {
                totalSize += thisChild.getSize();
            }
        }
        return totalSize;
    }

    public static void main(String[] args){
        ApfsDirectory myDir = new ApfsDirectory(null, "My Directory",
                LocalDateTime.now(), "Annie", LocalDateTime.now());
        System.out.println(myDir.getName());
        System.out.println(myDir.isLink());
    }
}
