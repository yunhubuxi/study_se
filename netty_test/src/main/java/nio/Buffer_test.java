package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Buffer_test {
    public static void main(String[] args) throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("D:\\ProjectDoc\\menu.sql", "rw");
        FileChannel inChannel = aFile.getChannel();

        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.err.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
