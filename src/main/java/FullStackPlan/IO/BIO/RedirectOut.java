package FullStackPlan.IO.BIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
    public static void main(String []args){
        try(
                PrintStream ps=new PrintStream(new FileOutputStream("out.txt"))
                ){
            System.setOut(ps);
            System.out.println("普通住房");
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
