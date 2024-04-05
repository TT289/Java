package socket;

import java.io.*;
import java.net.*;

public class bai1server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server is listening...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("[Client]: " + inputLine);
                out.println("Server: " + inputLine);

                BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                String serverInputLine = serverInput.readLine();
                out.println(serverInputLine);
            }

            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
