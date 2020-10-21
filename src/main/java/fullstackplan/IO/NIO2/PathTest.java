package fullstackplan.IO.NIO2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String []args){
        Path path=Paths.get(".");
        System.out.println(path.getNameCount());
        Path absolutePath=path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath.getRoot());
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));
        System.out.println(Paths.get("c:","test"));

    }
}
