package fullstackplan.IO.BIO;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterTest {
    public static void main(String []args){
        File file=new File(".");
        String []nameList=file.list(new MyFilenameFilter());
        for (String name:nameList){
            System.out.println(name);
        }
    }

    private static class MyFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".java")||new File(name).isDirectory();
        }
    }
}
