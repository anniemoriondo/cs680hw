package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void inStateStudentAndrewAdams(){
        String name = "Andrew Adams";
        String usAddr = "257 Elm St, Somerville, MA 02143";
        Student cut = Student.createInStateStudent(name, usAddr);
        assertEquals(cut.getName(), name);
        float expectedTuition = 1000;
        assertEquals(cut.getTuition(), expectedTuition);
        assertEquals(cut.getStatus(), StudentStatus.INSTATE);
    }

    @Test
    public void outStateStudentBethanyBillings(){
        String name = "Bethany Billings";
        String usAddr = "517 East Pike St, Seattle, WA 98122";
        int yrsInState = 2;
        Student cut = Student.createOutStateStudent(name, usAddr, yrsInState);
        assertEquals(cut.getName(), name);
        float expectedTuition = 2000;
        assertEquals(cut.getTuition(), expectedTuition);
        assertEquals(cut.getStatus(), StudentStatus.OUTSTATE);
    }

    @Test
    public void intlStudentCarolineCooper(){
        String name = "Caroline Cooper";
        String usAddr = "10 Milk St, Boston, MA 02108";
        int i20num = 5555555;
        String foreignAddr = "219 Onepu Rd, Lyall Bay, Wellington 6022, " +
                "New Zealand";
        Student cut = Student.createIntlStudent(name, usAddr, i20num,
                foreignAddr);
        assertEquals(cut.getName(), name);
        float expectedTuition = 3000;
        assertEquals(cut.getTuition(), expectedTuition);
        assertEquals(cut.getStatus(), StudentStatus.INTL);
    }
}
