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


        try {
            socketServer = new ServerSocket(8889);
            Socket socket = socketServer.accept();
            System.out.println("客户端连接成功...");
            InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            char[] c = new char[10];
            inputStreamReader.read(c);

            String s=String.valueOf(c);
            System.out.println(s);
            while (!socket.isClosed()){

                inputStreamReader.read(c);
                s=String.valueOf(c);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



//


}}
