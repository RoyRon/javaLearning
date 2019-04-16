package TencentClass_MaShiBing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 江映锋
 * Create on 2019/04/10
 */
public class SocketClientTest {
    public static void main(String[] args) {
        Socket socket;

        {
            try {
                socket = new Socket("127.0.0.1", 8889);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader fromKeyb = new BufferedReader(inputStreamReader);
                InputStreamReader fromServer = new InputStreamReader(socket.getInputStream());

                char[] c2 = new char[10];

                String toServerString = fromKeyb.readLine();

                while (!"bye".equals(toServerString)) {
                    System.out.println("client:" + toServerString);
                    outputStreamWriter.write(toServerString);
                    outputStreamWriter.flush();
                    fromServer.read(c2);

                    String fromServerString = String.valueOf(c2);
                    System.out.println("server:" + fromServerString);
                    toServerString = fromKeyb.readLine();

                }
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
