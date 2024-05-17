package buoi3;
import java.io.File;
import java.util.Scanner;

public class FileSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            System.out.println("Độ lớn file nhập vào là: " + file.length() + " bytes");
        } else {
            System.out.println("Không hợp lệ.");
        }

        scanner.close();
    }
}
