/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.ArrayList;

/**
 *
 * @author Wezzy
 */
public class MainMenu extends Menu
{

    PersonManager persons;

    public MainMenu(String header, String[] menuItems, PersonManager persons)
    {
        super(header, menuItems);
        this.persons = persons;
    }

    @Override
    protected void doAction(int option)
    {
        clear();
        System.out.println("Option " + option + " was selected");
        switch (option)
        {
            case 1:
                String[] s =
                {
                    "Edit List of Persons", "Get Emails", "Get IDs", "Get Names", "Get All details"
                };
                MenuPerson mp = new MenuPerson("Person Menu", s, persons);
                mp.run();
                break;
            case 2:
                System.out.println("Not implemented yet");
                break;
            case 3:
                System.out.println("Not implemented yet");
                break;
        }

    }

    public PersonManager refreshList()
    {
        return persons;
    }

}
