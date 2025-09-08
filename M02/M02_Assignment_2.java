/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   M02_Assignment_2.java
*/

public class M02_Assignment_2 {
    public static void main(String args[]) {
        Person person = new Person("Alice", "123 Main St", "555-1234", "alice@example.com");
        Student student = new Student("Bob", "456 Elm St", "555-5678", "bob@example.com", Student.SOPHOMORE);
        Employee employee = new Employee("Charlie", "789 Oak St", "555-9012", "charlie@example.com",
                                         "Room 101", 50000, new MyDate());
        Faculty faculty = new Faculty("David", "321 Maple St", "555-3456", "david@example.com",
                                      "Room 102", 70000, new MyDate(), "9am-5pm", "Professor");
        Staff staff = new Staff("Eve", "654 Pine St", "555-7890", "eve@example.com",
                                "Room 103", 40000, new MyDate(), "Administrator");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}
