package TencentClass_MaShiBing;

import java.io.*;

/**
 * @author 江映锋
 * Create on 2019/03/20
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        //   StreamTest.dataStream();
        StreamTest.bufferStream();

    }

    public static void dataStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeDouble(123456789l);
        dos.writeBoolean(true);
        ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
        DataInputStream dis = new DataInputStream(bis);
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());

    }

    public static void bufferStream() throws IOException {
//        FileInputStream fileInputStream=new FileInputStream("/Users/lizhi/IdeaProjects/javaLearning/a.txt");
//        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
//        byte[] bytes = new byte[10000];
//        bufferedInputStream.read(bytes, 0, bufferedInputStream.available());
//        for (int i=0;i<bytes.length;i++){
//            System.out.print((char)bytes[i]);
//        }

        FileReader fileReader = new FileReader("/Users/lizhi/IdeaProjects/javaLearning/a.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        while ((s=bufferedReader.readLine()) != null) {
            //每次调用readLine()方法，指向文件内容的指针都会下移一行，一开始我这里写的是 System.out.println(bufferedReader.readLine()); 会导致每空一行再打印一行
            System.out.println(s);
        }


    }

}
