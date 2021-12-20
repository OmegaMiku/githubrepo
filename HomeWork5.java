/**
 * Java 1. Homework 5
 *
 * @author Pavel Ermilov
 * @version 20.12.2021
 */

class HomeWork5 {
    public static void main(String[]args) {
        Employee[] empArr = new Employee[5];
            empArr[0] = new Employee("Ivanov Ivan", "Engineer", "ii@mailbox.com", 892312312, 70000, 41);
            empArr[1] = new Employee("Tajmahal Badalandabad", "Developer", "tb@mailbox.com", 892412312, 100000, 52);
            empArr[2] = new Employee("Howard Wolowitz", "Accountant", "hw@mailbox.com", 892512312, 50000, 45);
            empArr[3] = new Employee("Toph Bei Fong", "Secretary", "tbf@mailbox.com", 892612312, 30000, 18);
            empArr[4] = new Employee("Gundar Gundarson", "Security guard", "gg@mailbox.com", 892712312, 30000, 40);
        for (Employee employee : empArr) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private String position;
    private String email;
    private int phone;
    private int pay;
    private int age;

    Employee(String name, String position, String email, int phone, int pay, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.age = age;
    }

    int getAge() {
        return age;
    }

     @ Override
    public String toString() {
        return name + ", " + position + ", " + email + "," + phone + "," + pay + "," + age + ",";
    }
}