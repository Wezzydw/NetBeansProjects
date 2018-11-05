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
public class MenuPerson extends Menu
{

    PersonManager persons;
    Scanner scanner;

    public MenuPerson(String header, String[] menuItems, PersonManager persons)
    {
        super(header, menuItems);
        this.persons = persons;
        scanner = new Scanner(System.in);
    }

    @Override
    protected void doAction(int option)
    {

        clear();
        
        switch (option)
        {
            case 1:
                String[] namesAndId = new String[persons.getAllPersons().size()];
                for (int i = 0; i < persons.getAllPersons().size(); i++)
                {
                    namesAndId[i] = "ID: " +persons.getAllPersons().get(i).getId() + "Name: " + persons.getAllPersons().get(i).getName();
                }
                MenuPersonSelector mps = new MenuPersonSelector("Editing details of persons\nSelect one", namesAndId, persons);
                mps.run();
                break;
            case 2:
                for (Person p : persons.getAllPersons())
                {
                    System.out.println(p.getEmail());
                }
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 3:
                for (Person p : persons.getAllPersons())
                {
                    System.out.println(p.getId());
                }
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
            case 4:
                for (Person p : persons.getAllPersons())
                {
                    System.out.println(p.getName());
                }
                System.out.println("Press Enter to exit");
                scanner.nextLine();

                clear();
                break;
            case 5:
                for (Person p : persons.getAllPersons())
                {
                    System.out.println(p);
                }
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
        }
    }

}
