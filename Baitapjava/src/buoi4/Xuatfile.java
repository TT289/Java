package buoi4;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Xuatfile{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            try (FileWriter writer = new FileWriter("directory_structure.xml")) {
                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                writeDirectoryToXML(directory, writer, 0);
                System.out.println("Đã ghi cây thư mục vào file directory_structure.xml");
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không phải là một thư mục hợp lệ.");
        }

        scanner.close();
    }

    private static void writeDirectoryToXML(File directory, FileWriter writer, int indent) throws IOException {
        for (int i = 0; i < indent; i++) {
            writer.write("  ");
        }

        writer.write("<" + directory.getName() + ">\n");

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    writeDirectoryToXML(file, writer, indent + 1);
                } else {
                    for (int i = 0; i < indent + 1; i++) {
                        writer.write("  ");
                    }
                    writer.write("<file>" + file.getName() + "</file>\n");
                }
            }
        }

        for (int i = 0; i < indent; i++) {
            writer.write("  ");
        }
        writer.write("</" + directory.getName() + ">\n");
    }
}
