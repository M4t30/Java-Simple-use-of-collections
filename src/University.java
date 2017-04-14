/**
 * Created by M4teo on 10.03.2017.
 */

import java.util.*;

public class University
{
    List<Student> studentList = new ArrayList<Student>();
    List<Activity> activityList = new ArrayList<Activity>();

    public void addStudent(String name, String surname, StudentType type)
    {
        studentList.add(new Student(name, surname, type));
    }

    public void addActivity(String name)
    {
        activityList.add(new Activity(name));
    }

    public void assignStudentToActivity(Student aStudent, Activity anActivity)
    {
        int index = activityList.indexOf(anActivity);
        activityList.get(index).assignedStudents.add(aStudent);
    }

    public void removeStudent(Student aStudent)
    {
        studentList.remove(aStudent);

        for(int i = 0; i < activityList.size(); i++)
            if(activityList.get(i).assignedStudents.contains(aStudent))
                activityList.get(i).assignedStudents.remove(aStudent);

    }

    public void removeStudent(int id)
    {
        for(int i = 0; i < studentList.size(); i++)
            if(studentList.get(i).getId() == id)
                studentList.remove(i);

        for(int i = 0; i < activityList.size(); i++)
        {
            if(activityList.get(i).assignedStudents.isEmpty() == false)
                activityList.get(i).assignedStudents.remove(id);
        }
    }

    public void clearActivity(Activity anActivity)
    {
        for (int i = 0; i < activityList.size(); i++)
            if (activityList.get(i).name == anActivity.name)
                activityList.get(i).assignedStudents.clear();
    }

    public boolean isAssigned(Student aStudent, Activity anActivity)
    {
        if (anActivity.assignedStudents.contains(aStudent))
            return true;
        else
            return false;
    }

    public Queue<Student> freeStudents()
    {
        Queue<Student> freeStudents = new LinkedList<Student>();
        for (int i = 0; i < studentList.size(); i++)
        {
            int index = -1;

            for (int j = 0; j < activityList.size(); j++)
                if (activityList.get(j).assignedStudents.contains(studentList.get(i)))
                    index = 1;

            if(index == -1)
                freeStudents.add(studentList.get(i));
        }

        return freeStudents;
    }

    public Stack<Student> attendingOnNCourses(int amountOfCourses)
    {
        Stack<Student> nCoursesStudents = new Stack<Student>();

        for (int i = 0; i <studentList.size(); i++)
        {
            int numberOfCourses = 0;

            for (int j = 0; j < activityList.size(); j++)
                if(activityList.get(j).assignedStudents.contains(studentList.get(i)))
                    numberOfCourses++;

            if(numberOfCourses == amountOfCourses)
                nCoursesStudents.add(studentList.get(i));
        }

        return nCoursesStudents;
    }

    public Student theMostUrgent()
    {
        int index = -1;
        int maxNumberOfCourses = -1;

        for (int i = 0; i < studentList.size(); i++)
        {
            int numberOfCourses = 0;

            for (int j = 0; j < activityList.size(); j++)
                if(activityList.get(j).assignedStudents.contains(studentList.get(i)))
                    numberOfCourses++;

            if(maxNumberOfCourses < numberOfCourses)
            {
               maxNumberOfCourses = numberOfCourses;
              index = i;
            }
        }

        return studentList.get(index);
    }

    public Map<StudentType, Integer> amountOfSameTypeStudents(StudentType type)
    {
        Map<StudentType, Integer> studentMap = new HashMap<StudentType, Integer>();

        int amountOfTypeStudents = 0;

        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).type == type)
                amountOfTypeStudents++;

        studentMap.put(type, amountOfTypeStudents);

        return studentMap;
    }


    public void printInAlphabeticalOrder()
    {
        Collections.sort(studentList);
        for (Student s: studentList)
            System.out.println(s.toString());

    }

    public boolean twoPeopleTogether(Activity anActivity1, Activity anActivity2)
    {
        for (int i = 0; i < activityList.size(); i++)
        {
            for (int j = i + 1; j < activityList.size(); j++)
                if (activityList.get(i).name.equals(anActivity1.name) && activityList.get(j).name.equals(anActivity2.name)
                        && activityList.get(i).assignedStudents.isEmpty() == false && activityList.get(j).assignedStudents.isEmpty() == false)
                    if (Collections.disjoint(activityList.get(i).assignedStudents, activityList.get(j).assignedStudents))
                        return true;
                    else
                        return false;
        }
        return false;
    }
}
