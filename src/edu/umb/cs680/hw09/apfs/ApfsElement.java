package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.fs.FSElement;

import java.time.LocalDateTime;

public class ApfsElement extends FSElement{

    private String ownerName;
    private LocalDateTime modified;

    public ApfsElement (ApfsDirectory parent, String name, int size,
                        LocalDateTime creationTime){
        super((FSElement) parent, name, size, creationTime);
    }

    // Getters specific to ApfsElement
    public String getOwnerName(){return ownerName;}
    public LocalDateTime getModified(){return modified;}

    // Setters specific to ApfsElement
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setModified(LocalDateTime lastModified) { this.modified = lastModified; }
}
