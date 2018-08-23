package FullStackPlan.IO.BIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String [] args){
        try(
                FileOutputStream fos=new FileOutputStream("test.txt");
                PrintStream ps=new PrintStream(fos);
                ){
            ps.println("普通字符串");
            ps.println(new PrintStreamTest()); //直接使用PrintStream输出对象
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
