/**
 * Created by M4teo on 10.03.2017.
 */

import java.util.*;

enum StudentType
{
    STATIONARY,
    NONSTATIONARY,
    POSTGRADUATE;

    @Override
    public String toString()
    {
        switch (this)
        {
            case STATIONARY:
                return "STATIONARY";

            case NONSTATIONARY:
                return "NONSTATIONARY";

            case POSTGRADUATE:
                return "POSTGRADUATE";

            default:
                throw new IllegalArgumentException();
        }
    }
}

public class Student implements Comparable<Student>
{
    private static int sId = 0;
    private int id = 0;
    private String name;
    private String surname;
    StudentType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, String surname, StudentType type)
    {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.id = sId++;
    }

    public int compareTo(Student object)
    {
        int compareResult = this.surname.compareTo(object.surname);

        if (compareResult < 0)
            return -1;

        if (compareResult > 0)
            return 1;

        else
        {
            compareResult = this.name.compareTo(object.name);

            if (compareResult < 0)
                return -1;

            if (compareResult > 0)
                return 1;

            else
                return 0;
        }
    }

    public String toString()
    {
        String output = new String();
        output = "Name: " + name + " Surname: " + surname + " ID: " + id + " Type: " + type.toString();
        return output;
    }
}
