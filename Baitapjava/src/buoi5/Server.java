package buoi5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1845)) {
            System.out.println("Server is listening on port 12345");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;
                clientMessage = input.readLine();
                
                System.out.println("Client: " + clientMessage);

                System.out.print("Server: ");
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                output.println(message);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
