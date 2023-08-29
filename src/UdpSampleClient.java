import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSampleClient {public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            String message = "Hello, server!";
            byte[] sendData = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + serverResponse);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
