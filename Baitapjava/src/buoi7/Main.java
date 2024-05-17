package buoi7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class Main {

    public static void main(String[] args) {
        Connection conn = add.getCon(); // Em dùng hàm này để gọi class Add đã kết nối DB từ trước :)

        try {
            createTable(conn);

            String username = "user1";
            String password = "password1";
            registerUser(conn, username, password);

            String loginUsername = "user1";
            String loginPassword = "password1";
            boolean loggedIn = loginUser(conn, loginUsername, loginPassword);

            if (loggedIn) {
                System.out.println("Đăng nhập thành công. Chào mừng, " + loginUsername + "!");
            } else {
                System.out.println("Tên đăng nhập hoặc mật khẩu không hợp lệ.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL UNIQUE," +
                "password VARCHAR(64) NOT NULL)";
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(createTableSQL);
        }
    }

    private static void registerUser(Connection conn, String username, String password) throws SQLException {
        String hashedPassword = hashPassword(password);

        String insertUserSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(insertUserSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();
        }
    }

    private static boolean loginUser(Connection conn, String username, String password) throws SQLException {
        String hashedPassword = hashPassword(password);

        String selectUserSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(selectUserSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
