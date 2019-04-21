package TencentClass_MaShiBing;

import java.io.File;

/**
 * @author 江映锋
 * Create on 2019/03/11
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("/Users/lizhi/Documents/tmp");
        fileTree(file, 0);
    }
    public static void fileTree(File f, int level) {
        String preString = new String();
        for (int i = 0; i < level; i++) {
            preString += " ";
        }
        File[] child = f.listFiles();
        for (int i = 0; i < child.length; i++) {
            System.out.println(preString + child[i].getName());
            if (child[i].isDirectory()) {
                level++;
                fileTree(child[i], level);
            }
        }
    }
}
