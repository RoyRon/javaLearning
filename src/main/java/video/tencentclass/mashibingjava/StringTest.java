package video.tencentclass.mashibingjava;

/**
 * @author 江映锋
 * Create on 2019/03/05
 */
public class StringTest {
    public static void main(String[] args){
       StringTest stringTest=new StringTest();
       stringTest.stringToDoubleArray();
    }


    public void stringToDoubleArray(){
        String s="1,2;3,4,5;6,7,8";

        String s1[]=s.split(";");
        double[][] d=new double[s1.length][]; //指定二维数组第一维的长度
        for (int i=0;i<s1.length;i++){

            String[] s2=s1[i].split(",");
            d[i]=new double[s2.length];   //指定二维数组第二维的长度，不指定长度程序会报空指针异常 debug时报（Array reference expected）
            for (int j=0;j<s2.length;j++){
                d[i][j]=Double.parseDouble(s2[j]); //将字符串转换为double类型
                System.out.println("d"+"["+i+"]"+"["+j+"]"+"="+d[i][j]);
            }
        }

    }
}
