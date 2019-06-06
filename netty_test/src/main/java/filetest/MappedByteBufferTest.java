package filetest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * MappedByteBuffer只能往大增，不能减小，要不就是删除
 * 关键就是MappedByteBuffer的原理是什么
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        long fileSize = 1024 * 1024 * 1024;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(fileSize);
        File file = new File("D:\\ProjectDoc\\abcd");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
//        for (int i = 0; i < 10; i++) {
//            fileSize = fileSize /2;
//            TimeUnit.SECONDS.sleep(2);
//            fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);
//        }
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, Integer.MAX_VALUE);
        byte a = 2;
        for (int i = 0; i < 1000000; i++) {
            mappedByteBuffer.put(a);
        }
        TimeUnit.MINUTES.sleep(5);
//        mappedByteBuffer.get();
//        fileChannel.position(file.length());
//        ByteBuffer buffer = ByteBuffer.allocate(48);
//        AccessController accessController;


    }
//    public static void main(String[] args) {
//        File file = new File("D://data.txt");
//        long len = file.length();
//        System.out.println(len);
//        byte[] ds = new byte[(int) len];
//
//        try {
//            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
//                    .getChannel()
//                    .map(FileChannel.MapMode.READ_ONLY, 0, len);
//            for (int offset = 0; offset < len; offset++) {
//                byte b = mappedByteBuffer.get();
//                System.out.println(b);
//                ds[offset] = b;
//            }
//
//            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
//            while (scan.hasNext()) {
//                System.out.print(scan.next() + " ");
//            }
//
//        } catch (IOException e) {
//        }
//    }

}
