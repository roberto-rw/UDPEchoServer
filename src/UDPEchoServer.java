import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {

    private static final int ECHOMAX=255;
    public static void main(String[] args) throws IOException {
        int servPort = 8080;

        DatagramSocket socket = new DatagramSocket(servPort);
        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);


        while(true){
            socket.receive(packet);
            System.out.println("Handling client at " + packet.getAddress().getHostAddress()
                                                     + " on port " + packet.getPort());
            socket.send(packet);
            packet.setLength(ECHOMAX);
        }
    }
}