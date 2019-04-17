package FullStackPlan.IO.NIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
    public static void main(String []args) throws CharacterCodingException {
        Charset cn =Charset.forName("GBK");
        CharsetEncoder cEncoder=cn.newEncoder();
        CharsetDecoder cDecoder=cn.newDecoder();
        CharBuffer charBuffer=CharBuffer.allocate(8);
        charBuffer.put('中');
        charBuffer.put('q');
        charBuffer.flip();
        ByteBuffer byteBuffer=cEncoder.encode(charBuffer);

        for (int i=0;i<byteBuffer.limit();i++){
            System.out.println(byteBuffer.get(i)+" ");

        }
        System.out.println(cDecoder.decode(byteBuffer));

    }
}
