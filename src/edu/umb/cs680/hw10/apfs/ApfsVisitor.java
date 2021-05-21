package edu.umb.cs680.hw10.apfs;

public interface ApfsVisitor {
    void visit(ApfsLink link);
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);
}
