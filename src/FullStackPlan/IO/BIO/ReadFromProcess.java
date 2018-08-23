package FullStackPlan.IO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
    public static void main(String[]args) throws IOException {
        Process p=Runtime.getRuntime().exec("java");
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String buff=null;

        while ((buff=br.readLine())!=null){
            buff=new String(buff.toString().getBytes("GBK"),"UTF-8");
            System.out.println(buff);
        }
    }
}
