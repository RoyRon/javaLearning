package TencentClass_MaShiBing;

import java.io.*;
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
                BufferedReader fromKeyb = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter toServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String toServerString = fromKeyb.readLine();



//                while (!"bye".equals(toServerString)){
                    toServer.write(toServerString);
                    toServer.flush();
                    System.out.println("Client:" + toServerString);
//                    System.out.println("Server:" + fromServer.readLine());
//                    toServerString = fromKeyb.readLine();
//                }
//                fromKeyb.close();
//                fromServer.close();
//                toServer.close();
//                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
