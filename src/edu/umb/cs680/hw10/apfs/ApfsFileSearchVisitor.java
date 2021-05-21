package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsVisitor {
    // Desired filename and a list of files matching it
    private String fileName;
    private LinkedList<ApfsFile> foundFiles = new LinkedList<>();

    public ApfsFileSearchVisitor(String fileName){
        this.fileName = fileName;
    }

    // If we find a link or directory, just move on.
    public void visit(ApfsLink link) { return; }
    public void visit(ApfsDirectory dir) { return; }

    // If we find a file, check for a match and add any match.
    public void visit(ApfsFile file){
        if (file.getName().equals(fileName)){
            foundFiles.add(file);
        }
    }

    // Return our list of found files.
    public LinkedList<ApfsFile> getFoundFiles() { return foundFiles; }
}
