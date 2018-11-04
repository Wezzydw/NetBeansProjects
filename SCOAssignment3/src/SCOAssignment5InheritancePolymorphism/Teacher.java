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
public class Teacher extends Person
{
    ArrayList<String> subjects = new ArrayList();
    String initials;
    double salay;
    
    
    public Teacher(int id, String name, String initials){
            super(id,name);
            this.initials = initials;
            setEmail(getInitials() + "@easv.dk");
            
    }
    
    public List<String> getSubjects()
    {
        return subjects;
    }
    
    public String getInitials()
    {
        return initials;
    }
    
    public double getSalary()
    {
        return 0.0;
    }
    
    public void addSubject(String subject)
    {
        subjects.add(subject);
        
    }
    
    public void setSalary(double salary)
    {
        
    }
    
    public String toString()
    {
        return super.toString() + String.format("%-9s%-25s", "ini: " +initials, "F.Sub: " +subjects.get(0));
    }
}
