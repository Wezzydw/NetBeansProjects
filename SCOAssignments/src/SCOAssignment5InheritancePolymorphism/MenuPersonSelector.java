/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.List;
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
            String sid = menuItems[option - 1].substring(4, 7);
            int id = Integer.parseInt(sid);
            Person p = persons.getPerson(id);
            String s = "Editing ID: " + p.getId() + " Name; " + p.getName();
            String[] s1 =
            {
                "Set Name", "Set Email", "Show details"
            };
            MenuPersonEditor mpe = new MenuPersonEditor(s, s1, persons, p.getId());
            mpe.run();
            List<Person> pl = persons.getAllPersons();
            for (int i = 0; i < pl.size(); i++)
            {
                menuItems[i] = pl.get(i).getId() + " " +pl.get(i).getName();
            }
            refreshPrints(header, menuItems);
        }

    }

}
