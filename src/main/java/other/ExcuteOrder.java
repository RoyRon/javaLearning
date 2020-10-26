package other;

/**
 * @author 江映锋
 * Created on 2020/10/26
 */
public class ExcuteOrder {
    public static void main(String [] args){
System.out.println("*********创建子类1***********");
        Son son=new Son();
        System.out.println("*********创建子类2***********");
        Son son2=new Son();
        son2.getSomething();
        System.out.println("+++++++++创建父类1+++++++++++");
        Father father=new Father();
        father.getSomething();
        son.getSomething();

    }
}
class Father{
    public Father(){
        System.out.println("父类构造方法");
    }
    public void getSomething(){
        System.out.println("父类普通方法");
    }
    //父类普通模块
    {
        System.out.println("父类普通模块");
    }
    //父类静态模块
    static {
        System.out.println("父类静态模块");
    }


}
class Son extends Father{
    public Son(){
        System.out.println("子类构造方法");
    }
    public void getSomething(){
        System.out.println("子类普通方法");
    }
    //子类普通模块
    {
        System.out.println("子类普通模块");
    }
    //子类静态模块
    static {
        System.out.println("子类静态模块");
    }


}
