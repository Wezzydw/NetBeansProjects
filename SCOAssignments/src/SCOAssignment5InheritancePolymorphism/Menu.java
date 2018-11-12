package SCOAssignment5InheritancePolymorphism;

import java.util.Scanner;


public abstract class Menu
{

    // value used to exit the menu.
    // the value can be changed by the sub-class constructor.
    protected int EXIT_OPTION = 0;

    // The menu header text
    private String header;

    // The list of menu options texts.
    private String[] menuItems;


    protected abstract void doAction(int option);


    public Menu(String header, String[] menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }
    Scanner sc = new Scanner(System.in);


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
