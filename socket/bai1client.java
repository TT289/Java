package socket;

import java.io.*;
import java.net.*;

public class bai1client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("[Server]: " + in.readLine());
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
            String clientInputLine = clientInput.readLine();
            out.println(clientInputLine);
        }

        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
