/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.Scanner;

/**
 *
 * @author Wezzy
 */
public class MenuPersonSelector extends Menu
{

    PersonManager persons;
    String[] menuItems;
    String header;

    public MenuPersonSelector(String header, String[] menuItems, PersonManager persons)
    {
        super(header, menuItems);
        this.persons = persons;
        this.menuItems = menuItems;
        this.header = header;
    }

    @Override
    protected void doAction(int option)
    {
        clear();
        if (option > 0)
        {
            String sid = menuItems[option - 1].substring(0, 3);
            int id = Integer.parseInt(sid);
            Person p = persons.getPerson(id);
            String s = "Editing ID: " + p.getId() + "Name; " + p.getName();
            String[] s1 =
            {
                "Set Name", "Set Email"
            };
            MenuPersonsEditor mpe = new MenuPersonsEditor(s, s1, persons, p.getId());
            mpe.run();
            for (int i = 0; i < persons.getAllPersons().size(); i++)
            {
                menuItems[i] = persons.getAllPersons().get(i).getId() + " " + persons.getAllPersons().get(i).getName();
            }
            refreshPrints(header, menuItems);
        }

    }

}
