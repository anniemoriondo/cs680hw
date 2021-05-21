package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class ApfsReverseAlphaComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement elem1, ApfsElement elem2) {
        return elem2.getName().compareTo(elem1.getName());
    }
}
