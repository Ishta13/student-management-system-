package studentapp;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    Student s = new Student(name, email, course);
                    studentDAO.addStudent(s);
                    break;

                case 2:
                    List<Student> students = studentDAO.getAllStudents();
                    System.out.println("\n--- Student List ---");
                    for (Student stu : students) {
                        System.out.println("ID: " + stu.getId() + " | Name: " + stu.getName() +
                                " | Email: " + stu.getEmail() + " | Course: " + stu.getCourse());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    Student updatedStudent = new Student(idToUpdate, newName, newEmail, newCourse);
                    studentDAO.updateStudent(updatedStudent);
                    break;

                case 4:
                    System.out.print("Enter ID of student to delete: ");
                    int idToDelete = sc.nextInt();
                    studentDAO.deleteStudent(idToDelete);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
