/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Wezzy
 */
public class MenuPersonEditor extends Menu
{

    PersonManager persons;
    int id;
    String header;
    String[] menuItems;
    Scanner scanner;

    public MenuPersonEditor(String header, String[] menuItems, PersonManager persons, int id)
    {
        super(header, menuItems);
        this.persons = persons;
        this.id = id;
        this.header = header;
        this.menuItems = menuItems;
        scanner = new Scanner(System.in);
    }

    @Override
    protected void doAction(int option)
    {
        clear();
        Person p = persons.getPerson(id);
        switch (option)
        {
            case 1:
                String s;
                System.out.println("Insert Name:");
                p.setName(scanner.nextLine());
                String headerN = p.getName();
                refreshPrints("Showing " + id + " " + headerN, menuItems);
                break;
            case 2:
                System.out.println("Insert Email:");
                p.setEmail(scanner.next());
                break;
            case 3:
                clear();
                System.out.println(p);
                System.out.println("Press Enter to exit");
                scanner.nextLine();
                clear();
                break;
        }
    }

}
