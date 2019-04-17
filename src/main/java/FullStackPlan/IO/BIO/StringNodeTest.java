package FullStackPlan.IO.BIO;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(java.lang.String[] args){
        java.lang.String src="被读取的字符串";
        char[]buffer=new char[32];
        int hasRead=0;
        try(
                StringReader sr=new StringReader(src)
        ){
            while ((hasRead=sr.read(buffer))>0){
                System.out.println(new java.lang.String(buffer,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
try(StringWriter sw=new StringWriter()){
           sw.write("这是一句输出语句\n");
           sw.write("这是一句输出语句2");
           System.out.println(sw.toString());
} catch (IOException e) {
    e.printStackTrace();
}

    }
}
