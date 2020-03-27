package fullstackplan.IO.BIO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\光影风\\IdeaProjects\\untitled1\\" +
                    "src\\FullStackPlan\\IO\\BIO\\FileReaderTest.java");
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.println(new String(cbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
