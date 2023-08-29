import java.io.*;
import java.net.Socket;

public class TcpSampleClient {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 12345);

            // Get input and output streams for the socket
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Create readers and writers for easier communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true); // autoFlush

            // Send a message to the server
            String message = "Hello, server!";
            writer.println(message);

            // Read response from the server
            String serverResponse = reader.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close resources
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
