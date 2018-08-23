package FullStackPlan.IO.NIO;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String []args){
        CharBuffer buff=CharBuffer.allocate(8);
        System.out.println("capacity:"+buff.capacity());
        System.out.println("limit:"+buff.limit());
        System.out.println("position:"+buff.position());

        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("放入元素后position:"+buff.position());

        buff.flip();// 将position移到0，将limit移到position
        System.out.println("执行flip()方法后，limit:"+buff.limit());
        System.out.println("执行flip()方法后，position:"+buff.position());

        System.out.println("第一个元素(position=0):"+buff.get());
        System.out.println("取出第一个元素后，position:"+buff.position());//读取时未带索引，position加1

        buff.clear();//将position移到0，将limit移到capacity
        System.out.println("执行clear()方法后，limit:"+buff.limit());
        System.out.println("执行clear()方法后，position:"+buff.position());

        System.out.println("第三个元素(position=2):"+buff.get(2));
        System.out.println("读取后，position:"+buff.position()); //采用索引方法读取不影响position

    }
}
