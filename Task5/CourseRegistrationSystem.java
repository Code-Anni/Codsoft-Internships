import java.util.*;

class Course {
    String code, title, description;
    int capacity;
    List<String> schedule;

    Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class CourseRegistrationSystem {
    static Map<String, Course> courseDatabase = new HashMap<>();
    static Map<String, Student> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        courseDatabase.put("PCC-Cs503", new Course("PCC-Cs503", "Welcome to OOPS World", "Basics of java", 5, Arrays.asList("Mon 31st-oct-24", "Fri 4th-nov-24")));
        studentDatabase.put("1234", new Student("1234", "Alice"));

        while (true) {
            System.out.println("\n1. List Courses\n2. Register Course\n3. Drop Course\n4. Exit\nChoose an option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: listCourses(); break;
                case 2: registerCourse(scanner); break;
                case 3: dropCourse(scanner); break;
                case 4: System.out.println("Bye!"); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    static void listCourses() {
        courseDatabase.values().forEach(c -> System.out.println(c.code + ": " + c.title + " (" + c.capacity + " slots) " + c.schedule));
    }

    static void registerCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentDatabase.get(studentId);

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = courseDatabase.get(courseCode);

        if (course.capacity > 0) {
            student.registeredCourses.add(course);
            course.capacity--;
            System.out.println("Registered!");
        } else {
            System.out.println("Course full!");
        }
    }

    static void dropCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentDatabase.get(studentId);

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        Course course = courseDatabase.get(courseCode);

        if (student.registeredCourses.remove(course)) {
            course.capacity++;
            System.out.println("Dropped!");
        } else {
            System.out.println("Not registered for this course!");
        }
    }
}
