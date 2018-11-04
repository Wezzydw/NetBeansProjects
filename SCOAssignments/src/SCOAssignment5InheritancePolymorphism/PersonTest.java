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
public class PersonTest
{

    private static ArrayList<Person> list = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        Person p1 = new Person(100, "Hans Nielsen", "hni@easv.dk") {};
        Person p2 = new Person(101, "Niels Hansen", "nha@easv.dk") {};
        Person p3 = new Person(102, "Ib Boesen", "ibo@easv.dk") {};
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Teacher t1 = new Teacher(200, "Bent Pedersen", "bpe");
        Teacher t2 = new Teacher(201, "Jesper Andersen", "jan");
        list.add(t1);
        list.add(t2);
        t1.addSubject("SCO");
        t2.addSubject("SDE");
        Student s1 = new Student(300, "Bo Ibsen", "EASV");
        list.add(s1);
        GradeInfo sco12 = new GradeInfo("CS", 12);
        GradeInfo sce4 = new GradeInfo("CS", 4);
        GradeInfo ito7 = new GradeInfo("CS", 7);
        s1.addGrade(sco12);
        s1.addGrade(sce4);
        s1.addGrade(ito7);
        List<Student> list1 = new ArrayList();
        List<Teacher> list2 = new ArrayList();
        PersonManager pm = new PersonManager();

        System.out.println("ID\t" + "Name\t\t" + "Email\t\t" + "Initial\t"
                + "Subject\t" + "Education\t" + "Grade");
        for (Person x : list)
        {
            pm.addPerson(x);
            System.out.println(x);
        }
        list1 = pm.getAllStudents();
        for (Student x : list1)
        {
            System.out.println(x);
            
        }
        list2 = pm.getAllTeacher();
        for (Teacher x : list2)
        {
            System.out.println(x);
        }
    }

}
