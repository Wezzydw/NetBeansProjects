/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.lang.reflect.*;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class StudentTest {

    @Test
    public void testGetSetMethods() {
        Method[] methods = Student.class.getMethods();

        ArrayList<String> methodsMustBe = new ArrayList(
                Arrays.asList(
                        "getStudentId", "setStudentId",
                        "getName", "setName",
                        "getMultiplier", "setMultiplier"
                )
        );

        methodsMustBe.forEach((String mm) -> {
            boolean found = false;
            for (Method method : methods) {
                if (method.getName().equals(mm)) {
                    found = true;
                }
            }
            if (!found) {
                fail("Missing get/set method in Student: " + mm);
            }
        });

        for (Method m : Student.class.getMethods()) {
            Parameter[] params = m.getParameters();
            if (m.getName().startsWith("get")) {
                if (params.length != 0) {
                    fail("No parameters allowed in get method: " + m.getName());
                }
            }
        }

        for (Method m : Student.class.getMethods()) {
            Parameter[] params = m.getParameters();
            if (m.getName().startsWith("set")) {
                if (params.length == 0) {
                    fail("Parameters in set method missing: " + m.getName());
                }
            }
        }

    }

    /**
     * Test of get and setMultiplier method, of class Student.
     */
    @Test
    public void testGetSetMultiplier() {
        double multiplier = 0.06;
        Student instance = new Student();
        assertFalse("Should return false if value is incorrect", instance.setMultiplier(multiplier));
        assertFalse("Should not change value if incorrect", instance.getMultiplier() == multiplier);

        instance = new Student();
        multiplier = 1.06 * 1.08;
        assertTrue("Correct value not allowed?", instance.setMultiplier(multiplier));
        assertTrue("Value did not change although correct", instance.getMultiplier() == multiplier);
        multiplier = 1.06;
        assertTrue("Correct value not allowed?", instance.setMultiplier(multiplier));
        assertTrue("Value did not change although correct", instance.getMultiplier() == multiplier);
        multiplier = 1.08;
        assertTrue("Correct value not allowed?", instance.setMultiplier(multiplier));
        assertTrue("Value did not change although correct", instance.getMultiplier() == multiplier);
    }

    /**
     * Test of get and setGrade method, of class Student.
     */
    @Test
    public void testSetGrade() {
        double mult1 = 1.06;
        double mult2 = 1.08;
        double grade = 12 * mult1 * mult2 * 1.001; // just very little over
        Student instance = new Student();
        assertFalse("Should return false if value is incorrect", instance.setGrade(grade));
        assertFalse("Should not change value if incorrect", instance.getGrade() == grade);

        grade = -3.01 * mult1 * mult2; // just very little under
        instance = new Student();
        assertFalse("Should return false if value is incorrect", instance.setGrade(grade));
        assertFalse("Should not change value if incorrect", instance.getGrade() == grade);

        instance = new Student();
        grade = 12 * mult1;
        assertTrue("Correct value not allowed?", instance.setGrade(grade));
        assertTrue("Value has not changed, although it is correct?", instance.getGrade() == grade);
        grade = 12 * mult2;
        assertTrue("Correct value not allowed?", instance.setGrade(grade));
        assertTrue("Value has not changed, although it is correct?", instance.getGrade() == grade);
        grade = 12 * mult1 * mult2; // Exactly top grade
        assertTrue("Correct value not allowed?", instance.setGrade(grade));
        assertTrue("Value has not changed, although it is correct?", instance.getGrade() == grade);
        grade = 6.6666666;
        assertTrue("Correct value not allowed?", instance.setGrade(grade));
        assertTrue("Value has not changed, although it is correct?", instance.getGrade() == grade);
    }

    /**
     * Test of get and setName method, of class Student.
     */
    @Test
    public void testSetName() {
        char[] invalidChars = ".\\/,()&%€#!$".toCharArray();
        Student instance = new Student();
        String name = "";
        assertFalse("Should return false if value is incorrect", instance.setName(name));
        assertFalse("Should not change value if incorrect", name.equals(instance.getName()));

        assertFalse("Should return false if value is incorrect", instance.setName(null));

        for (char invalidChar : invalidChars) {
            instance = new Student();
            name = invalidChar + "";
            assertFalse("Should return false if value is incorrect", instance.setName(name));
            assertFalse("Should not change value if incorrect", name.equals(instance.getName()));

            instance = new Student();
            name = "" + invalidChar + " check";
            assertFalse("Should return false if value is incorrect", instance.setName(name));
            assertFalse("Should not change value if incorrect", name.equals(instance.getName()));

            instance = new Student();
            name = "start " + invalidChar + " end";
            assertFalse("Should return false if value is incorrect", instance.setName(name));
            assertFalse("Should not change value if incorrect", name.equals(instance.getName()));
        }

        instance = new Student();
        name = "InvalidNameOnlyOneWord";
        assertFalse("Should return false if value is incorrect", instance.setName(name));
        assertFalse("Should not change value if incorrect", name.equals(instance.getName()));

        instance = new Student();
        name = "Valid Name=";
        assertTrue("Correct value not allowed?", instance.setName(name));
        assertTrue("Value has not changed, although it is correct?", name.equals(instance.getName()));
        name = "Valid Name Many Spaces No Problem Att all uncaps";
        assertTrue("Correct value not allowed?", instance.setName(name));
        assertTrue("Value has not changed, although it is correct?", name.equals(instance.getName()));
        name = "a e";
        assertTrue("Correct value not allowed?", instance.setName(name));
        assertTrue("Value has not changed, although it is correct?", name.equals(instance.getName()));

    }

    /**
     * Test of setStudentId method, of class Student.
     */
    @Test
    public void testSetStudentId() {
        int studentId = 0;
        Student instance = new Student();
        assertFalse("Student id must be >= 0", instance.setStudentId(-1));
        assertFalse("Student id must not change if not valid",instance.getStudentId()==-1);
        assertTrue("StudentId 0 is valid, but returns false", instance.setStudentId(0));
        assertTrue("StudentId 65536 is valid, but returns false", instance.setStudentId(65536));
    }

}
