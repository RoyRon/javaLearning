package book.ligangcrazyjava;

import org.junit.Test;

/**
 * @author 江映锋
 * Create on 2019/05/20
 */
 class TimingOfVariateInitialization {
    int var1;


    public TimingOfVariateInitialization(int var1) {
        System.out.println("后执行构造器");
        this.var1 = var1;
    }

    //定义时指定初始化值(比静态初始化块先执行）
    int var3=1;
    {
        System.out.println("先执行非静态初始化块");
        var2 = "a";
        var3=3;
    }

    //定义时指定初始化值(比静态初始化块后执行）
    //定义时指定值和非静态初始化模块按在代码的位置顺序执行
    String var2 = "b";

    public String toString() {
        return "var1=" + var1 + " var2=" + var2+" var3="+var3;
    }


}
public class TimingOfVariateInitializationTest{

    @Test
    public void test() {
        TimingOfVariateInitialization t1 = new TimingOfVariateInitialization(1);
        System.out.println(t1);
    }
}

