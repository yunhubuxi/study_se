package filetest;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 * MappedByteBuffer只能往大增，不能减小，要不就是删除
 * 关键就是MappedByteBuffer的原理是什么
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception{
        int fileSize = 1024 * 1024 *1024;
        System.out.println(fileSize);
        File file = new File("D:\\ProjectDoc\\abcd");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
//        for (int i = 0; i < 10; i++) {
//            fileSize = fileSize /2;
//            TimeUnit.SECONDS.sleep(2);
//            fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);
//        }
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);
        mappedByteBuffer.clear();
    }
}
