/**
 * Created by M4teo on 10.03.2017.
 */

import java.util.*;

public class Activity
{
    public String name;
    public Set<Student> assignedStudents = new HashSet<Student>();

    public Activity(String name)
    {
        this.name = name;
    }
}
