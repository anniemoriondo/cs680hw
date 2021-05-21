package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
    private ApfsElement target;

    public ApfsLink (ApfsDirectory parent, String name, LocalDateTime creationTime,
                 ApfsElement target, String ownerName, LocalDateTime modified){
        // File size of link is always 0
        super(parent, name, 0, creationTime, ownerName, modified);
        this.target = target;
        if (parent != null){ parent.appendChild(this); }
    }

    public boolean isDirectory() { return false; }

    public boolean isLink() { return true; }

    public FSElement getTarget(){ return target; }

    // Info about target
    public String targetName(){ return target.getName(); }

    public String targetLocation(){
        return target.getParent() != null ?
                target.getParent().getName() : null;
    }

    public int targetSize(){
        // Returns target's total size if it's a directory; else return its size
        return target.isDirectory() ?
                ((ApfsDirectory)target).getSize() : target.getSize();
    }

    public boolean targetIsDirectory(){ return target.isDirectory(); }

    public boolean targetIsLink(){return target.isLink();}


}
