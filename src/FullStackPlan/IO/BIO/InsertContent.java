package FullStackPlan.IO.BIO;


import java.io.*;

public class InsertContent {
    public static void insertContent(String fileName, String insertContent, long pos) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        FileInputStream fis = new FileInputStream(tmp);
        FileOutputStream fos = new FileOutputStream(tmp);
        raf.seek(pos);
        byte[] buff = new byte[64];
        int hasRead = 0;
        while ((hasRead = raf.read(buff)) > 0) {
            fos.write(buff, 0, hasRead);
        }
        raf.seek(pos);
        raf.write(insertContent.getBytes());
        while ((hasRead = fis.read(buff)) > 0) {
            raf.write(buff, 0, hasRead);
        }
    }

    public static void main(String[] args) throws IOException {
        insertContent("out.txt", "//11\r\n", 4500);
    }}