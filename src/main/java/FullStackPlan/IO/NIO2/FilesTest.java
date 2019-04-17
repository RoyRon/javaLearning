package FullStackPlan.IO.NIO2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String []args) throws Exception {
        Files.copy(Paths.get("/Users/lizhi/IdeaProjects/javaLearning/src/FullStackPlan/IO/NIO2/FilesTest.java"),new FileOutputStream("a.txt"));
        System.out.println(Files.isHidden(Paths.get("/Users/lizhi/IdeaProjects/javaLearning/out2.txt")));
        List<String> lines=Files.readAllLines(Paths.get("out2.txt"),Charset.forName("UTF-8"));
        System.out.println(lines);

        List<String> poem=new ArrayList<>();
        poem.add("上山打老虎");
        Files.write(Paths.get("a.txt"),poem,Charset.forName("gbk"));


    }
}
