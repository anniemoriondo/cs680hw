package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor {
    // LinkedList to store the crawled files.
    private LinkedList<ApfsFile> files = new LinkedList<>();

    public void visit(ApfsFile file) { files.add(file); }

    public void visit(ApfsDirectory dir) { return; }

    public void visit(ApfsLink link) { return; }

    public LinkedList<ApfsFile> getFiles(){return files;}
}
