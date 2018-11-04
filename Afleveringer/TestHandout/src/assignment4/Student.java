/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author jeppjleemoritzled
 */
public class Student
{

    private int studentId;
    private String name;
    private double grade;
    private double multiplier;

    /**
     * Create 4 instance fields
     *
     * studentId (int), name (String), grade (double), multiplier (double)
     *
     * Implement the getters and setters for each field.
     */

    /**
     *
     * @return the value of the instance field
     */
    public double getMultiplier()
    {
        return multiplier;
    }

    /**
     * The setter for the multiplier must check that the value is either 1.08 *
     * 1.06 or 1.08 or 1.06
     *
     * If not, then do not update the value
     *
     * @param multiplier
     * @return if the input was valid
     */
    public boolean setMultiplier(double multiplier)
    {
        if (multiplier == 1.06 * 1.08 || multiplier == 1.08 || multiplier == 1.06)
        {

            this.multiplier = multiplier;
            return true;
        }
        return false;
    }

    /**
     *
     * @return the value of the instance field
     */
    public double getGrade()
    {
        return grade;
    }

    /**
     * The setter for grade, must check that it is a value between -3 *
     * multiplier and 12 * multiplier, both inclusive Do not set the value, if
     * outside of this range
     *
     * @param grade
     * @return if input was valid
     */
    public boolean setGrade(double grade)
    {

        if (grade >= -3 * 1.06 * 1.08 && grade <= 12 * 1.06 * 1.08)
        {
            this.grade = grade;
            return true;
        } else
        {
            return false;
        }
    }

    /**
     *
     * @return the value of the instance field
     */
    public String getName()
    {
        return name;
    }

    /**
     * The setter for name, must check that the name is valid. A name must hold
     * at least 2 words (seperated by space) A name must not be null or empty. A
     * name cannot have the following characters: .\/,()&%€#!$ Do not set the
     * value, if the name is not valid.
     *
     * @param name
     * @return if input was valid
     */
    public boolean setName(String name)
    {
        String illegal = ".\\/,()&%€#!$";
        if (name == null || name == "")
        {
            return false;
        }

        for (int i = 0; i < name.length(); i++)
        {
            for (int j = 0; j < illegal.length(); j++)
            {
                if (name.charAt(i) == illegal.charAt(j))
                {
                    return false;
                }
            }
        }

        if (name.contains(" "))
        {
            this.name = name;
            return true;
        }

        return false;
    }

    /**
     *
     * @return the value of the instance field
     */
    public int getStudentId()
    {
        return studentId;
    }

    /**
     * The setter for studentId must check that it is larger than -1 Do not set
     * the value, if this is false.
     *
     * @param studentId
     * @return
     */
    public boolean setStudentId(int studentId)
    {
        if (studentId > -1)
        {
            this.studentId = studentId;
            return true;
        }
        return false;
    }

}
