package FullStackPlan.IO.NIO2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
    public static void main(String[]args) throws IOException {
        Files.walkFileTree(Paths.get("/Users/lizhi/IdeaProjects/javaLearning/src/FullStackPlan/IO/"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问"+file+"文件");
                if (file.endsWith("F.java")){
                    System.out.println("done");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问"+dir+"路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
