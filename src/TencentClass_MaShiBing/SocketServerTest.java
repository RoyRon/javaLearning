package TencentClass_MaShiBing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 江映锋
 * Create on 2019/04/10
 */
public class SocketServerTest {
    public static void main(String[] args) {
        ServerSocket socketServer;

        {
            try {
                socketServer = new ServerSocket(8889);

                Socket socket = socketServer.accept();
                System.out.println("客户端连接成功...");
                BufferedReader serverFromKeyb = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter toClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                while (true){
                System.out.println("Client:" + fromClient.readLine());}
//                String toClientString = serverFromKeyb.readLine();

//                while (!"bye".equals(toClientString)) {

//                    toClient.write(toClientString);
//                    toClient.flush();
//                    System.out.println("Server:" + toClientString);
//                    System.out.println("Client:" + fromClient.readLine());
//                    toClientString=serverFromKeyb.readLine();
//                }
//                serverFromKeyb.close();
//                fromClient.close();
//                toClient.close();
//                serverFromKeyb.close();
//                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
