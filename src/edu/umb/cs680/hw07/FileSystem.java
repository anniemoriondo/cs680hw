package edu.umb.cs680.hw07;
// From Notes 13

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem(){}

    public static FileSystem getFileSystem(){
        if (instance == null){
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs(){
        return this.rootDirs;
    }

    public void appendRootDir(Directory root){
        this.rootDirs.add(root);
    }

    public static void main(String[] args){
        System.out.println("Is this thing on?");
    }
}
