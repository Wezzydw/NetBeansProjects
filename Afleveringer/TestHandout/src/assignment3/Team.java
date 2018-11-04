package assignment3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Team
{

    private ArrayList<TeamMember> members = new ArrayList<>();

    /**
     *
     * @param m an instance of TeamMember Adds a teammember to the instance
     * field members
     */
    public void addTeamMember(TeamMember m)
    {
        members.add(m);
    }

    // Nothing to do here!
    public void addTeamMembers(ArrayList<TeamMember> t)
    {
        members.addAll(t);
    }

    // Nothing to do here!
    public ArrayList<TeamMember> getAllMembers()
    {
        return members;
    }

    /**
     *
     * @param m the TeamMember to remove
     * @return if a TeamMember was removed
     */
    public boolean removeTeamMember(TeamMember m)
    {
        return members.remove(m);
    }

    /**
     *
     * @return the next available id The id must start at 0. If a members is
     * removed from the list, the id must be freed for the next member. The next
     * id must always be the smallest possible id number
     */
    public int getNextId()
    {
        int nextId = 0;

        for (TeamMember x : members)
        {
            if (x.getId() == nextId)
            {
                nextId++;
            }
        }
        return nextId;
    }

    /**
     *
     * @param role, a String representing the role of the TeamMember
     * @return an ArrayList of all TeamMember that has the specified role
     */
    public ArrayList<TeamMember> retriveMembersByRole(String role)
    {

        ArrayList<TeamMember> roleList = new ArrayList();
        for (TeamMember x : members)
        {
            if (x.getRole() == role)
            {
                roleList.add(x);
            }
        }

        return roleList;
    }

    /**
     * Sort the TeamMember list in ascending order by name
     */
    public void sortByNameAsc()
    {
        ArrayList<String> names = new ArrayList();
        ArrayList<TeamMember> tmpCopy = new ArrayList();

        for (TeamMember x : members)
        {
            names.add(x.getName());
        }
        Collections.sort(names);

        for (String y : names)
        {
            for (TeamMember z : members)
            {
                if (z.getName() == y)
                {
                    tmpCopy.add(z);
                }
            }

        }
        members = tmpCopy;

    }

    /**
     * Sort the TeamMember list in descending order by role
     */
    public void sortByRoleDesc()
    {
        ArrayList<String> roles = new ArrayList();
        ArrayList<TeamMember> tmpCopy = new ArrayList();

        for (TeamMember x : members)
        {
            roles.add(x.getRole());
        }
        Collections.sort(roles);

        for (String y : roles)
        {
            for (TeamMember z : members)
            {
                if (z.getRole() == y)
                {
                    tmpCopy.add(z);
                }
            }

        }
        members.clear();
        for (int i = 0; i < tmpCopy.size(); i++)
        {
            members.add(tmpCopy.get(tmpCopy.size() - i - 1));
        }

    }

}
