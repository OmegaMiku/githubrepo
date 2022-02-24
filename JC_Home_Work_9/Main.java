import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "Java, Phyton, C", 3);
        Student student2 = new Student("Ekaterina", "Java, C", 2);
        Student student3 = new Student("Andrei", "Phyton, C", 2);
        Student student4 = new Student("Egor", "Phyton, C", 2);
        Student student5 = new Student("Pavel", "Java, C, Phyton", 3);
        Student student6 = new Student("Alexandra", "Java, Phyton, C", 3);
        Student student7 = new Student("Svetlana", "Phyton", 1);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);

        List<String> getBestStudents =
                list.stream()
                    .filter(s -> s.getCountOfCourses() > 2)
                    .map(s -> s.getName())
                    .collect(Collectors.toList());

        System.out.println(getBestStudents);

        List<String> getCourseJava =
                list.stream()
                    .filter(s -> s.getCourses().startsWith("Java"))
                    .map(s -> s.getName())
                    .collect(Collectors.toList());

        System.out.println(getCourseJava);


    }
}
