package FullStackPlan.IO.BIO;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
    public static void main(String [] args){
        try(
                PushbackReader pr=new PushbackReader(new FileReader("C:\\Users\\光影风\\IdeaProjects\\untitled1\\src\\FullStackPlan\\IO\\BIO\\PushbackTest.java"),64)
                ){
            char[] buf=new char[32];
            String lastConent="";
            int hasRead=0;
            while((hasRead=pr.read(buf))>0){
                String content=new String(buf,0,hasRead);
                int targetIndex=0;
                if((targetIndex=(lastConent+content).indexOf("new PushbackReader"))>0){
                    pr.unread((lastConent+content).toCharArray());
                    int len=targetIndex>32?32:targetIndex;
                    pr.read(buf,0,len);
                    System.out.println(new String(buf,0,len));
                    System.exit(0);

                }else {
                    System.out.println(lastConent);
                    lastConent=content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
