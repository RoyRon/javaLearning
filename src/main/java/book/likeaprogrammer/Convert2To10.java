package book.likeaprogrammer;

import org.junit.Test;

public class Convert2To10 {
    public void convert2to10(String binary){
        int result=0;
//        int result= (int)(Math.pow(2,0)*0+Math.pow(2,1)*1);
        int i=0;
        while (i<binary.length()){
//            result+=Math.pow(2,binary.length()-i-1)*String.valueOf(binary.charAt(i));
            i++;
        }
        System.out.println(result);
    }
    @Test
    public void testconver2to10(){
//        convert2to10("1");
        System.out.println(1<<3);
    }
}
