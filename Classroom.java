import java.util.LinkedHashMap;
import java.util.Map;

public class Classroom {
    private Teacher teacher;
    private Map<String, Integer> students;

    public Classroom(Teacher teacher) {
        this.teacher = teacher;
        this.students = new LinkedHashMap<>();
    }

    public void addStudent(String studentName) {
        students.put(studentName, null);
        System.out.println(studentName + " added to the classroom.");
    }

    public void removeStudent(String studentName) {
        if (students.containsKey(studentName)) {
            students.remove(studentName);
            System.out.println(studentName + " removed from the classroom.");
        } else {
            System.out.println(studentName + " is not in the classroom.");
        }
    }

    public void assignGrade(String studentName, int grade) {
        if (students.containsKey(studentName)) {
            students.put(studentName, grade);
            System.out.println("Grade " + grade + " assigned to " + studentName);
        } else {
            System.out.println(studentName + " is not in the classroom.");
        }
    }

    public void displayClassroom() {
        System.out.println("Classroom Information:");
        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Subject: " + teacher.getSubject());
        System.out.println("Students:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            String studentName = entry.getKey();
            Integer grade = entry.getValue();
            System.out.println(studentName + " - " + (grade != null ? grade : "No grade assigned"));
        }
    }
}
