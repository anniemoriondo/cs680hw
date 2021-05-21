package edu.umb.cs680.hw10.apfs;

import java.time.LocalDateTime;

public class ApfsCountingVisitor implements ApfsVisitor {

    // Store the numbers of directories, files, and links.
    int dirNum = 0;
    int fileNum = 0;
    int linkNum = 0;

    // Increment the appropriate counter for each element visited
    public void visit(ApfsLink link){ linkNum += 1; }

    public void visit(ApfsDirectory dir){
        dirNum += 1;
        System.out.println("Visiting a directory!");
    }

    public void visit(ApfsFile file){ fileNum += 1; }

    // Getters for the info counts
    public int getDirNum() { return dirNum; }
    public int getFileNum() { return fileNum; }
    public int getLinkNum() { return linkNum;}

    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        ApfsDirectory dir1 = new ApfsDirectory(null, "dir1", now, "Annie", now);
        ApfsDirectory dir2 = new ApfsDirectory(dir1, "dir2", now, "Annie", now);
        ApfsCountingVisitor counter = new ApfsCountingVisitor();
        dir1.accept(counter);
        System.out.println(counter.getDirNum());
    }

}
