package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class ApfsSizeComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement elem1, ApfsElement elem2) {
        // Sorts directories first in order of total size,
        // then files in order of size.
        if( elem1.isDirectory() && elem2.isDirectory()){
            // If they're both directories, compare total size.
            return ((ApfsDirectory) elem1).getTotalSize() -
                    ((ApfsDirectory) elem2).getTotalSize();
        }
        return elem1.getSize() - elem2.getSize();
    }
}
