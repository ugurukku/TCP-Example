import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(9090);

            while (true) {

                Socket client = ss.accept();

                OutputStream out = new DataOutputStream(client.getOutputStream());

                out.write("HTTP/1.1 200 \r\n".getBytes(StandardCharsets.UTF_8));
                out.write("Content-Type: image/png\r\n".getBytes(StandardCharsets.UTF_8));
                out.write("Connection: close\r\n".getBytes(StandardCharsets.UTF_8));
                out.write("\r\n".getBytes(StandardCharsets.UTF_8));

                FileInputStream fileInputStream =
                        new FileInputStream("C:\\****\\****\\****\\****\\****\\photo.png");

                out.write(fileInputStream.readAllBytes());

                out.flush();
                out.close();

                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

