package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;

public class ApfsComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement elem1, ApfsElement elem2) {
        return elem1.getName().compareTo(elem2.getName());
    }
}
