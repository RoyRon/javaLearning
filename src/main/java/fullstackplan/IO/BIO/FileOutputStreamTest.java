package fullstackplan.IO.BIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/FullStackPlan/IO/BIO/FileInputStreamTest.java");
            FileOutputStream fos = new FileOutputStream("1533863090703.java");
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
            fis.close();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
