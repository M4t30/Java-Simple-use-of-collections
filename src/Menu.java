/**
 * Created by M4teo on 11.03.2017.
 */

import java.util.*;

public class Menu
{
    public static void main(String[] args)
    {
        University anUniversity = new University();
        anUniversity.addStudent("Mateusz", "Mazur", StudentType.STATIONARY);
        anUniversity.addStudent("Agnieszka", "Kajak", StudentType.STATIONARY);
        anUniversity.addStudent("Katarzyna", "Sztacheta", StudentType.STATIONARY);
        anUniversity.printInAlphabeticalOrder();

        anUniversity.addActivity("Programowanie w JAVA");
        anUniversity.assignStudentToActivity(anUniversity.studentList.get(0), anUniversity.activityList.get(0));

        anUniversity.addActivity("Grafika komputerowa");
        anUniversity.assignStudentToActivity(anUniversity.studentList.get(0), anUniversity.activityList.get(0));

        anUniversity.removeStudent(anUniversity.studentList.get(0));
        System.out.println("PO USUNIĘCIU PO OBIEKCIE STUDENT");
        anUniversity.printInAlphabeticalOrder();

        System.out.println("PO USUNIĘCIU PO ID");
        anUniversity.removeStudent(1);
        anUniversity.printInAlphabeticalOrder();

        anUniversity.clearActivity(anUniversity.activityList.get(0));

        if(anUniversity.isAssigned(anUniversity.studentList.get(0), anUniversity.activityList.get(0)))
            System.out.println("Jest taki student na zajęciach");

        anUniversity.freeStudents();

        anUniversity.attendingOnNCourses(1);

        System.out.println("Ilość studentów stacjonarnych: " + anUniversity.amountOfSameTypeStudents(StudentType.STATIONARY));

        System.out.println("Najpilniejszy student to: " + anUniversity.theMostUrgent());

        if(anUniversity.twoPeopleTogether(anUniversity.activityList.get(0), anUniversity.activityList.get(1)))
            System.out.println("Istnieje część wspólna");
    }
}
