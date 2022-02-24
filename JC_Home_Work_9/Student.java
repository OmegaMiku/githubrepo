import java.util.Objects;

public class Student {

    private String name;
    private String courses;
    private int countOfCourses;

    public Student(String name, String courses, int countOfCourses) {
        this.name = name;
        this.courses = courses;
        this.countOfCourses = countOfCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getCountOfCourses() {
        return countOfCourses;
    }

    public void setCountOfCourses(int countOfCourses) {
        this.countOfCourses = countOfCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses='" + courses + '\'' +
                ", countOfCourses=" + countOfCourses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return countOfCourses == student.countOfCourses && Objects.equals(name, student.name) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courses, countOfCourses);
    }
}
