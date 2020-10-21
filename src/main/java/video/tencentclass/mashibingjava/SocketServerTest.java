package video.tencentclass.mashibingjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 江映锋
 * Create on 2019/04/10
 */
public class SocketServerTest {
    public static void main(String[] args) {
        ServerSocket socketServer;


        try {
            socketServer = new ServerSocket(8889);
            Socket socket = socketServer.accept();
            System.out.println("客户端连接成功...");
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());

            BufferedReader fromKeyb = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter toClient = new PrintWriter(socket.getOutputStream());
            char[] c = new char[10];
            inputStreamReader.read(c);
            String fromClientString = String.valueOf(c, 0, c.length);

            System.out.println("client:" + fromClientString);
            String toClientString = fromKeyb.readLine();
            System.out.println("server:" + toClientString);
            while (!"bye".equals(toClientString)) {
                toClient.write(toClientString);
                toClient.flush();
                inputStreamReader.read(c);
                fromClientString = String.valueOf(c, 0, c.length);
                System.out.println("client:" + fromClientString);
                toClientString = fromKeyb.readLine();
                System.out.println("server:" + toClientString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//


    }
}
