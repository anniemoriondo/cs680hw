package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class ApfsSizeComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement elem1, ApfsElement elem2) {
        // Compares directories by total size, links and files by size
        int elem1size = elem1.isDirectory() ?
                ((ApfsDirectory) elem1).getTotalSize() : elem1.getSize();
        int elem2size = elem2.isDirectory() ?
                ((ApfsDirectory) elem2).getTotalSize() : elem2.getSize();
        return elem1size - elem2size;
    }
}
