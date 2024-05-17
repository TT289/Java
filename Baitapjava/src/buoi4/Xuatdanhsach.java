package buoi4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}

public class Xuatdanhsach {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Phung Tien Trung", 18, 4.0));
        students.add(new Student("Tran Thi B", 21, 3.8));
        students.add(new Student("Le Van C", 22, 3.2));

        try (FileWriter writer = new FileWriter("students.xml")) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<students>\n");

            for (Student student : students) {
                writer.write("  <student>\n");
                writer.write("    <name>" + student.getName() + "</name>\n");
                writer.write("    <age>" + student.getAge() + "</age>\n");
                writer.write("    <gpa>" + student.getGpa() + "</gpa>\n");
                writer.write("  </student>\n");
            }

            writer.write("</students>\n");

            System.out.println("Đã ghi danh sách sinh viên vào file students.xml");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
}
