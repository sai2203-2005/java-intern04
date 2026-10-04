import java.util.Scanner;

public class StudentManagementSystem {

    // Maximum number of students
    static final int MAX_STUDENTS = 100;

    // Arrays to store student information
    static int[] studentIds = new int[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static int[] studentAges = new int[MAX_STUDENTS];

    // Number of students currently stored
    static int studentCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add a student
    static void addStudent() {

        if (studentCount == MAX_STUDENTS) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        // Check whether ID already exists
        if (findStudentIndex(id) != -1) {
            System.out.println("Student ID already exists!");
            return;
        }

        sc.nextLine(); // Clear buffer

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentAges[studentCount] = age;

        studentCount++;

        System.out.println("Student added successfully!");
    }

    // Method to search for a student
    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.println("Student not found!");
        } else {
            System.out.println("\nStudent Found!");
            System.out.println("ID   : " + studentIds[index]);
            System.out.println("Name : " + studentNames[index]);
            System.out.println("Age  : " + studentAges[index]);
        }
    }

    // Method to update a student
    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        int index = findStudentIndex(id);

        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        sc.nextLine(); // Clear buffer

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();

        System.out.print("Enter new age: ");
        int newAge = sc.nextInt();

        studentNames[index] = newName;
        studentAges[index] = newAge;

        System.out.println("Student updated successfully!");
    }

    // Method to display all students
    static void displayStudents() {

        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");

        System.out.printf("%-10s %-20s %-10s%n",
                "ID", "NAME", "AGE");

        System.out.println("----------------------------------------");

        for (int i = 0; i < studentCount; i++) {

            System.out.printf("%-10d %-20s %-10d%n",
                    studentIds[i],
                    studentNames[i],
                    studentAges[i]);
        }
    }

    // Method to find student index using ID
    static int findStudentIndex(int id) {

        for (int i = 0; i < studentCount; i++) {

            if (studentIds[i] == id) {
                return i;
            }
        }

        return -1;
    }
}
