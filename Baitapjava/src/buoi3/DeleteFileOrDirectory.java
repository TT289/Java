package buoi3;
import java.io.File;
import java.util.Scanner;

public class DeleteFileOrDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục hoặc file: ");
        String path = scanner.nextLine();

        File fileOrDirectory = new File(path);

        if (!fileOrDirectory.exists()) {
            System.out.println("Thư mục hoặc file không tồn tại.");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa?");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                deleteFileOrDirectory(fileOrDirectory);
                System.out.println("Đã xóa thành công.");
            } else {
                System.out.println("Hủy bỏ thao tác.");
            }
        }

        scanner.close();
    }

    private static void deleteFileOrDirectory(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File file : fileOrDirectory.listFiles()) {
                deleteFileOrDirectory(file);
            }
        }
        fileOrDirectory.delete();
    }
}
