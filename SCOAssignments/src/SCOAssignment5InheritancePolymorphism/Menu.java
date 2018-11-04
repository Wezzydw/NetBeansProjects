package SCOAssignment5InheritancePolymorphism;

import java.util.Scanner;

/**
 * Abstract class implementing the basic functionality of a console based menu
 * class. A menu can be created by sub-classing this class and implement the
 * abstract method doAction(option).
 *
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 *
 * super(“some header”, “menuoption1", "menuoption2");
 *
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
public abstract class Menu
{

    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;

    /**
     * Abstract method stating what should be done, when a menu option is
     * selected. The method must be overridden by the sub-class.
     *
     * @param option the menu option that has been selected.
     */
    protected abstract void doAction(int option);

    /**
     * Creates an instance of the class with the given header text and menu
     * options.
     *
     * @param header The header text of the menu.
     * @param menuItems The list of menu items texts.
     */
    public Menu(String header, String[] menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }
    Scanner sc = new Scanner(System.in);

    /**
     * Executes the menu until the EXIT_OPTION has been selected. This is an
     * implementation of the Template Method design pattern.
     */
    public void run()
    {
        boolean done = false;
        while (!done)
        {

            showMenu();
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION)
            {
                done = true;
            }
        }
    }

    /**
     * Returns a valid menu-option input from the keyboard. The method continues
     * prompting for an option value, until a valid option has been input.
     *
     * @return A valid menu option.
     */
    private int getOption()
    {
        int a = sc.nextInt();
        if (a < menuItems.length + 1)
        {
            return a;
        } else
        {
            return 0;
        }
    }

    /**
     * Prints out a console menu with a header text and a list of menu options.
     * The menu options will be assigned the numbers from 1 to the number of
     * options in the menu.
     */
    private void showMenu()
    {
        int i = 1;
        System.out.println(header);
        for (String s : menuItems)
        {
            System.out.println(i + ": " + s);

            i++;
        }
        System.out.println("0: Exit");
    }

    /**
     * Waits until the 'enter' key is pressed.
     */
    protected void pause()
    {
        boolean t = true;

        while (t)
        {
            if (sc.nextLine().length() == 0)
            {
                System.out.println("puase");
                break;
            }
        }
    }

    /**
     * Clears the screen by writing several empty lines.
     */
    protected void clear()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println("");
        }
    }

    protected void refreshPrints(String header, String[] menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }
}