package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement target;

    public Link (Directory parent, String name, LocalDateTime creationTime,
                 FSElement target){
        // File size of link is always 0
        super(parent, name, 0, creationTime);
        this.target = target;
        if (parent != null){ parent.appendChild(this); }
    }

    public boolean isDirectory() {
        return false;
    }

    // Info about target
    public String targetName(){ return target.getName(); }

    public String targetLocation(){ return target.getParent().getName(); }

    public int targetSize(){
        return target.isDirectory() ? ((Directory)target).getTotalSize() : target.getSize();
    }

    public boolean targetIsDirectory(){ return target.isDirectory(); }


}
