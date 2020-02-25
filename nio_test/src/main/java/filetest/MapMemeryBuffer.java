package filetest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapMemeryBuffer {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 280 * 1024);
        byte[] bbb = new byte[280 * 1024 * 1024];
        FileInputStream fis = new FileInputStream("d:\\123.avi");
        FileOutputStream fos = new FileOutputStream("d:\\123.avi1");
        FileChannel fc = fis.getChannel();
        // 得到当前的时间
        long timeStar = System.currentTimeMillis();
        // 1 读取
//        fc.read(byteBuf);
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        System.out.println(fc.size() / 1024);
        // 得到当前的时间
        long timeEnd = System.currentTimeMillis();
        System.out.println("Read time :" + (timeEnd - timeStar) + "ms");

        long aaa = System.currentTimeMillis();
        for (int offset = 0; offset < bbb.length; offset++) {
            byte b = byteBuf.get(offset);
            bbb[offset] = b;
        }
        System.out.println("copy time :"+ (System.currentTimeMillis()-aaa)+ "ms");
        timeStar = System.currentTimeMillis();
        //2.写入，包括拷贝时间
        fos.write(bbb);
//        mbb.flip();
        timeEnd = System.currentTimeMillis();
        System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
        fos.flush();
        fc.close();
        fis.close();
        MappedByteBufferTest();
    }

    static void MappedByteBufferTest() {
        try {

            RandomAccessFile source = new RandomAccessFile("d:\\123.avi", "r");
            RandomAccessFile target = new RandomAccessFile("d:\\123.avi2", "rw");
            FileChannel in = source.getChannel();
            FileChannel out = target.getChannel();
            long size = in.size();
            long start = System.currentTimeMillis();
            MappedByteBuffer mbbi = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
            MappedByteBuffer mbbo = out.map(FileChannel.MapMode.READ_WRITE, 0, size);

            for (int i = 0; i < size; i++) {
                byte b = mbbi.get(i);
                mbbo.put(i, b);
            }
            source.close();
            target.close();
            System.out.println("Spend: " + (System.currentTimeMillis() - start) + "ms");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
