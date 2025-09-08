/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   M02_Assignment_2.java
*/

public class M02_Assignment_2 {
    public static void main(String args[]) {
        Person person = new Person("Homer", "742 Evergreen Terrace", "555-1234", "homer@example.com");
        Student student = new Student("Marge", "123 Fake St", "555-5678", "marge@example.com", Student.SOPHOMORE);
        Employee employee = new Employee("Bart", "116 Cherry St", "555-9012", "bart@example.com", "Room 101", 50000, new MyDate());
        Faculty faculty = new Faculty("Lisa", "321 Maple St", "555-3456", "lisa@example.com", "Room 102", 70000, new MyDate(), "9am-5pm", "Professor");
        Staff staff = new Staff("Maggie", "654 Pine St", "555-7890", "maggie@example.com", "Room 103", 40000, new MyDate(), "Administrator");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}
