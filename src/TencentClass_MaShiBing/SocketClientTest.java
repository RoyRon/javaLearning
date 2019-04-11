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
                 OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
                 InputStreamReader inputStreamReader=new InputStreamReader(System.in);
                 BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                 String c=new String();
                 c= bufferedReader.readLine();
                 while (!"bye".equals(c)){
                     outputStreamWriter.write(c);
                     outputStreamWriter.flush();
                     c= bufferedReader.readLine();

                 }
socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
