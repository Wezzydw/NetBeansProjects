/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Wezzy
 */
public class MenuStudentEditor extends Menu
{

    PersonManager persons;
    int id;
    String header;
    String[] menuItems;
    Scanner scanner;
    List<Student> students;

    public MenuStudentEditor(String header, String[] menuItems, PersonManager persons, int id)
    {
        super(header, menuItems);
        this.persons = persons;
        this.id = id;
        this.header = header;
        this.menuItems = menuItems;
        scanner = new Scanner(System.in);
        students = persons.getAllStudents();

    }

    @Override
    protected void doAction(int option)
    {
        clear();
        Student stud = (Student)persons.getPerson(id);
        //"Show Gradereport", "Show education", "Show Average grade", "Show grade in specific subject", "Set Name", "Set Email", "Add grade"
        switch (option)
        {
           
            case 1:
                clear();
                System.out.println("Gradereport: " + stud.getGradeReport());
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 2:
                clear();
                System.out.println("Education: " + stud.getEducation());
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 3:
                clear();
                System.out.println("Average Grade: " + stud.getAverageGrade());
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 4:
                clear();
                System.out.println("Enter one of the following subjects");
                ArrayList<String> sub = new ArrayList();
                
                for (GradeInfo g : stud.getGradeReport())
                {
                    for (int i = 0; i < sub.size(); i++)
                    {
                        if (sub.get(i) != g.getSubject())
                        {
                            sub.add(g.getSubject());
                        }
                        
                    }
                    if (sub.isEmpty())
                            sub.add(g.getSubject());
                }
                for (String s1 : sub)
                {
                    System.out.println(s1);
                }
                String check = scanner.nextLine();
                int index = -2;
                for (int i = 0; i < sub.size(); i++)
                {

                    if(sub.get(i).equals(check))
                    {
                        index = i;
                        break;
                    }
                    
                }
                
                System.out.println("Grade in " + check + " is: " + stud.getGrade(sub.get(index)));
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 5:
                String s;
                System.out.println("Insert Name:");
                s = scanner.nextLine();
                persons.getPerson(id).setName(s);
                header = persons.getPerson(id).getName();
                clear();
                refreshPrints("Showing ID: " + id + " Name: " + header, menuItems);
                break;
            case 6:
                System.out.println("Insert Email:");
                persons.getPerson(id).setEmail(scanner.next());
                break;
            case 7:
                clear();
                System.out.println("Type in subject");
                String subj = scanner.next();
                System.out.println("Grade");
                int gra = scanner.nextInt();
                GradeInfo grade = new GradeInfo(subj, gra);
                stud.addGrade(grade);
                clear();
                break;
        }
    }

}
