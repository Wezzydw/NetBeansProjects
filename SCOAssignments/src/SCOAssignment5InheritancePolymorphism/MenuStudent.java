/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuStudent extends Menu
{

    PersonManager persons;
    Scanner scanner;

    public MenuStudent(String header, String[] menuItems, PersonManager persons)
    {
        super(header, menuItems);
        this.persons = persons;
        scanner = new Scanner(System.in);
    }

    protected void doAction(int option)
    {
        clear();
        List<Student> students = new ArrayList();
        students = persons.getAllStudents();

        switch (option)
        {
            case 1:
                String[] namesAndId = new String[students.size()];
                for (int i = 0; i < students.size(); i++)
                {
                    namesAndId[i] = "ID: " + students.get(i).getId() + " Name: " + students.get(i).getName();
                }
                MenuStudentSelector mss = new MenuStudentSelector(
                        "Editing details of persons\nSelect one", namesAndId, persons);
                mss.run();
                break;
            case 2:
                double grades = 0;
                for (Student x: students)
                {
                    grades += x.getAverageGrade();
                }
                System.out.println("Average of all grades: " + grades/students.size());
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 3:
                for (Student s : students)
                {
                    System.out.println(s);
                }
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
        }
    }
}
