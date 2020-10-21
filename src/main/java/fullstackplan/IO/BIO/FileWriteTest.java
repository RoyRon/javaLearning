package fullstackplan.IO.BIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("poem.txt")) {
            fw.write("锦瑟-李商隐\r\n");
            fw.write("锦瑟无端五十弦，一弦一柱思华年\r\n");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
