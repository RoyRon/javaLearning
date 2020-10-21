package fullstackplan.IO.BIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[]args){
        try(FileInputStream fis=new FileInputStream("C:\\Users\\光影风\\IdeaProjects\\untitled1\\src\\FullStackPlan\\IO\\BIO\\RedirectIn.java")) {
            System.setIn(fis);
            Scanner sc=new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
