/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCOAssignment5InheritancePolymorphism;

/**
 *
 * @author WezzyLaptop
 */
abstract public class Person
{
    private int id;
    private String name;
    private String email;
    
    public Person (int id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Person (int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setName (String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String toString()
    {
        return String.format("%-8s%-25s%-25s", "ID: " +id, "Name: " +name, "Email:" +email);
    }
}


