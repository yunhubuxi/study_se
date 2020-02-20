package iotest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        method5();
    }

    public static void method5() throws Exception{
        TimeUnit.SECONDS.sleep(10);
        String word2048 = " \u0001\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F��������������������������������������������������������������������������������������������������������������������������������\n";

        System.out.println("开始写入");
        long timeStar = System.currentTimeMillis();
        File file = new File("D:\\ProjectDoc\\5678");
        //  必须采用RandomAccessFile，并且是rw模式
        RandomAccessFile acf = new RandomAccessFile(file, "rw");
        FileChannel fc = acf.getChannel();
        byte[] bs = word2048.getBytes();
        int len = bs.length * 1000;
        long offset = 0;
        int i = 2000;
        while (i > 0) {
            MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len);
            for (int j = 0; j < 1000; j++) {
                mbuf.put(bs);
            }
            System.err.println(mbuf.isLoaded());
            MappedByteBuffer aa = mbuf.load();
            System.err.println(aa.isLoaded());
            offset = offset + len;
            i = i - 1000;


        }
        fc.close();
        long timeEnd = System.currentTimeMillis();
        System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
        BufferedInputStream bufferedInputStrea;
    }

    public static void method4() {
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try {
            aFile = new RandomAccessFile("D:\\ProjectDoc\\打印模板工具.rar", "rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            ByteBuffer buff = ByteBuffer.allocate((int) aFile.length());
            buff.clear();
            fc.read(buff);
            //System.out.println((char)buff.get((int)(aFile.length()/2-1)));
            //System.out.println((char)buff.get((int)(aFile.length()/2)));
            //System.out.println((char)buff.get((int)(aFile.length()/2)+1));
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
                if (fc != null) {
                    fc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method3() {
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try {
            aFile = new RandomAccessFile("D:\\ProjectDoc\\打印模板工具.rar", "rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
            // System.out.println((char)mbb.get((int)(aFile.length()/2-1)));
            // System.out.println((char)mbb.get((int)(aFile.length()/2)));
            //System.out.println((char)mbb.get((int)(aFile.length()/2)+1));
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: " + (timeEnd - timeBegin) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
                if (fc != null) {
                    fc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
