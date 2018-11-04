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
public class MenuPersonsEditor extends Menu
{

    PersonManager persons;
    int id;
    String header;
    String[] menuItems;
    Scanner scanner;

    public MenuPersonsEditor(String header, String[] menuItems, PersonManager persons, int id)
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

        switch (option)
        {
            case 1:
                String s;
                System.out.println("Insert Name:");
                s = scanner.nextLine();
                persons.getPerson(id).setName(s);
                header = persons.getPerson(id).getName();
                refreshPrints("Editing " + id + " " + header, menuItems);
                break;
            case 2:
                System.out.println("Insert Email:");
                persons.getPerson(id).setEmail(scanner.next());
                break;
        }
    }

}
