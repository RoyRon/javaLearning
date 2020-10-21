package book.acraftsmanapproach;

import java.util.Scanner;


public class Triangle {
    public static void main(String[] args){
        int a;
        int b;
        int c;
        do {
            System.out.println("请输入三个1到300的整数");
            Scanner input = new Scanner(System.in);
             a = input.nextInt();
             b = input.nextInt();
             c = input.nextInt();
        } while ((a<1||a>300)||(b<1||b>300)||(c<1||c>300));
        Triangle triangle =new Triangle();
        triangle.typeOfTrangle(a,b,c);
    }

    /**
     * 输入三条边判断能不能组成三角形，能则返回true，不能就返回flase
     * @param a 边长a
     * @param b
     * @param c
     * @return
     */
   public boolean isTrangle(int a,int b,int c){
       if (a<b+c&&b<a+c&&c<a+b) return true;
       else return false;
   }

    /**
     * 先调用isTrangle方法判断三边能否组成三角形，再根据三边关系判断三角形类型
     * @param a
     * @param b
     * @param c
     */
   public void typeOfTrangle(int a,int b,int c){
       if(isTrangle(a, b, c)){
           if(a*a==b*b+c*c||b*b==a*a+c*c||c*c==a*a+b*b)System.out.print("直角三角形");
           else if(a==b&&b==c)System.out.print("等边三角形"); //我一开始判断条件是a==b&&b==c&&c==a，有冗余
           else if(a!=b&&b!=c&&c!=a)System.out.print("普通三角形");
           else System.out.print("等腰三角形");
       }
       else System.out.print("不是三角形");
   }
}
