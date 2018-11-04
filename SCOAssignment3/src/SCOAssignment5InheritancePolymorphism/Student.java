/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WezzyLaptop
 */
public class Student extends Person
{
    private String education;
    private ArrayList<GradeInfo> gradeReport;
    
    public Student (int id, String name, String education)
    {
        super(id,name);
        this.education = education;
        gradeReport = new ArrayList();
        setEmail(name.replace(" ", "_") + "@easv.dk");
        
        
        
    }
    
    public List<GradeInfo> getGradeReport()
    {
        return gradeReport;
    }
    
    public String getEducation()
    {
        return education;
    }
    
    public double getAverageGrade()
    {
        double grade = 0;
        for (GradeInfo x : gradeReport)
        {
            grade += x.getGrade();
        }
        return grade/gradeReport.size();
    }
    public int getGrade (String subject)
    {
        for (GradeInfo x : gradeReport)
        {
            if(x.getSubject() == subject)
                return x.getGrade();
        }
        return -1;
    }
    
    public void addGrade(GradeInfo grade)
    {
        gradeReport.add(grade);
    }
    
    public String toString()
    {
        return super.toString() + String.format("%-15s%-15s", "Edu: " +education, "AvgGrade: " +getAverageGrade());
    }
}
