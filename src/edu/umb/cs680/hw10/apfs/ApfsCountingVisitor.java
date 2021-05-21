package edu.umb.cs680.hw10.apfs;

public class ApfsCountingVisitor implements ApfsVisitor{

    // Store the numbers of directories, files, and links.
    int dirNum = 0;
    int fileNum = 0;
    int linkNum = 0;

    // Increment the appropriate counter for each element visited
    public void visit(ApfsLink link){ linkNum++; }

    public void visit(ApfsDirectory dir){ dirNum++;}

    public void visit(ApfsFile file){ fileNum++; }

    // Getters for the info counts
    public int getDirNum() { return dirNum; }
    public int getFileNum() { return fileNum; }
    public int getLinkNum() { return linkNum;}
}
