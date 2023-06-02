import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Banana", "Linear Algebra"));
        teachers.add(new Teacher("Jude Martinez", "Object Oriented"));
        teachers.add(new Teacher("Michael Setiawan", "English"));

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Teacher and Subject");
            System.out.println("2. Choose an Existing Teacher");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter teacher name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter teacher subject: ");
                    String teacherSubject = scanner.nextLine();
                    Teacher newTeacher = new Teacher(teacherName, teacherSubject);
                    teachers.add(newTeacher);
                    Classroom classroom = new Classroom(newTeacher);
                    performClassroomOperations(classroom, scanner);
                }
                case 2 -> {
                    if (teachers.isEmpty()) {
                        System.out.println("No existing teachers available.");
                        break;
                    }
                    System.out.println("Available Teachers:");
                    for (int i = 0; i < teachers.size(); i++) {
                        Teacher teacher = teachers.get(i);
                        System.out.println((i + 1) + ". " + teacher.getName() + " (" + teacher.getSubject() + ")");
                    }
                    System.out.print("Choose a teacher (enter the number): ");
                    int teacherChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (teacherChoice < 1 || teacherChoice > teachers.size()) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }
                    Teacher chosenTeacher = teachers.get(teacherChoice - 1);
                    Classroom existingClassroom = new Classroom(chosenTeacher);
                    performClassroomOperations(existingClassroom, scanner);
                }
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting.");
    }

    private static void performClassroomOperations(Classroom classroom, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Display Classroom");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    classroom.addStudent(studentName);
                }
                case 2 -> {
                    System.out.print("Enter student name: ");
                    String removeStudentName = scanner.nextLine();
                    classroom.removeStudent(removeStudentName);
                }
                case 3 -> {
                    System.out.print("Enter student name: ");
                    String gradeStudentName = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    classroom.assignGrade(gradeStudentName, grade);
                }
                case 4 -> classroom.displayClassroom();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
