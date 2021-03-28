package edu.umb.cs680.hw04;

import java.lang.System;

public class Student {
    private float tuition;
    private String name;
    private int i20num;
    private String usAddr;
    private int yrsInState;
    private String foreignAddr;
    private StudentStatus status;

    private Student(String name, String usAddr, int yrsInState, int i20num, String foreignAddr,
                    StudentStatus status){
        this.name = name;
        this.usAddr = usAddr;
        this.yrsInState = yrsInState;
        this.i20num = i20num;
        this.foreignAddr = foreignAddr;
        this.status = status;
        if (status == StudentStatus.INSTATE){
            this.tuition = 1000;
        } else if (status == StudentStatus.OUTSTATE){
            this.tuition = 2000;
        } else if (status == StudentStatus.INTL){
            this.tuition = 3000;
        }

    }

    public static Student createInStateStudent(String name, String usAddr){
        return new Student(name, usAddr,0, 0, "", StudentStatus.INSTATE);
    }

    public static Student createOutStateStudent(String name, String usAddr, int yrsInState){
        return new Student(name, usAddr, yrsInState, 0, "", StudentStatus.OUTSTATE);
    }

    public static Student createIntlStudent(String name, String usAddr, int i20num,
                                            String foreignAddr){
        return new Student(name, usAddr, 0, i20num, foreignAddr, StudentStatus.INTL);
    }

    // Getter methods.
    public float getTuition(){
        return this.tuition;
    }

    public String getName(){
        return this.name;
    }

    public StudentStatus getStatus(){
        return this.status;
    }

    public static void main(String[] args){
        // Not my real address, don't worry!
        Student me = createInStateStudent("Annie Moriondo",
                "81 Holland St, Somerville, MA 02144");
        System.out.println(me.getName());
        System.out.println(me.getTuition());
        System.out.println(me.getStatus());
    }

}

