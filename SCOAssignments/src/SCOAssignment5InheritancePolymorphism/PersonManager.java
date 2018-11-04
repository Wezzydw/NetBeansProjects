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
public class PersonManager
{

    List<Person> persons = new ArrayList();

    public PersonManager()
    {
    }

    public Person getPerson(int id)
    {
        for (Person x : persons)
        {
            if (x.getId() == id)
            {
                return x;
            }
        }
        return null;
    }

    public void addPerson(Person p)
    {
        if (persons.isEmpty())
        {
            persons.add(p);
        } else
        {
            for (int i = 0; i < persons.size(); i++)
            {
                if (!(persons.get(i).getId() == p.getId()))
                {
                    persons.add(p);
                    break;
                }
            }
        }

    }

    public void removePerson(int id)
    {
        for (Person x : persons)
        {
            if (x.getId() == id)
            {
                persons.remove(id);
            }
        }
    }

    public List<Person> getAllPersons()
    {
        return persons;
    }

    public List<Student> getAllStudents()
    {
        List<Student> s = new ArrayList();
        for (Person x : persons)
        {
            if (x.getClass() == Student.class)
            {
                s.add((Student) x);
            }
        }
        return s;
    }

    public List<Teacher> getAllTeacher()
    {
        List<Teacher> s = new ArrayList();
        for (Person x : persons)
        {
            if (x.getClass() == Teacher.class)
            {
                s.add((Teacher) x);
            }
        }
        return s;
    }

    public void operation()
    {

    }
}
