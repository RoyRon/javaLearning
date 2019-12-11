package LikeAProgrammer;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class ConversionOf2And10 {
    public void conver10to2(int number){
        int  quotient;
        int remainder;
        String [] result = new String[24];
        int i=0;
        while (number>0) {
            quotient = number / 2;
            remainder = number % 2;
            number=quotient;
            result[i]=String.valueOf(remainder);
//            System.out.print(result[i]);
            i++;
        }
        for (int j=result.length-1;j>=0;j--){
            if (result[j]!=null) {
                System.out.print(result[j]);
            }
        }
    }
    @Test
    public void testconver10to2() throws IOException {
        System.out.println("请输入一个正整数：");
        int number=System.in.read(); //Junit 不支持控制台键盘输入
        conver10to2(number);
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int number=input.nextInt();
        ConversionOf2And10 c=new ConversionOf2And10();
        c.conver10to2(number);
    }
}
