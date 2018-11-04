/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

import java.util.List;

/**
 *
 * @author Wezzy
 */
public class MenuStudentSelector extends Menu
{

    PersonManager persons;
    String[] menuItems;
    String header;

    public MenuStudentSelector(String header, String[] menuItems, PersonManager persons)
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
            String s = "Showing ID: " + p.getId() + " Name: " + p.getName();
            String[] s1 =
            {
                "Show Gradereport", "Show education", "Show Average grade", "Show grade in specific subjects", "Set Name", "Set Email", "Add grade"
            };
            MenuStudentEditor mse = new MenuStudentEditor(s, s1, persons, p.getId());
            mse.run();
            for (int i = 0; i < persons.getAllStudents().size(); i++)
            {
                menuItems[i] = "ID: " +persons.getAllStudents().get(i).getId() + " " + "Name: " + persons.getAllStudents().get(i).getName();
            }
            refreshPrints(header, menuItems);
        }

    }

}
