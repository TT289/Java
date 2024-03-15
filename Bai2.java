package Java;

import java.io.File;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn của thư mục hoặc tệp tin bạn muốn xoá: ");
        String path = scanner.nextLine();
        
        File fileOrDir = new File(path);
        
        if (fileOrDir.exists()) {
            System.out.print("Bạn có chắc chắn muốn xoá? Nhập '1' ");
            String xét = scanner.nextLine();
            if (xét.equals("1")) {
                boolean deleted = Tậptin(fileOrDir);
                if (deleted) {
                    System.out.println("Xoá thành công.");
                } else {
                    System.out.println("Không thể xoá.");
                }
            } else {
                System.out.println("Hủy bỏ việc xoá.");
            }
        } else {
            System.out.println("Thư mục hoặc tệp tin không tồn tại.");
        }
        
        scanner.close();
    }
    
    private static boolean Tậptin(File fileOrDir) {
        if (fileOrDir.isDirectory()) {
            File[] contents = fileOrDir.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    Tậptin(f);
                }
            }
        }
        return fileOrDir.delete();
    }
}
