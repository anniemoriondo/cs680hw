package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor {
    private LinkedList<ApfsFile> files = new LinkedList<>();

    @Override
    public void visit(ApfsFile file) {
        files.add(file);
    }

    @Override
    public void visit(ApfsDirectory dir) {
        return;
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }
}
