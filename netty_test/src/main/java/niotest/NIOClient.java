package niotest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NIOClient {
    public static void main(String[] args) throws Exception {
        //1、创建socket 通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9001));
        //2、设置异步非阻塞
        socketChannel.configureBlocking(false);
        //指定缓冲区大小
        ByteBuffer writeBuffer = ByteBuffer.allocate(32);
        ByteBuffer readBuffer = ByteBuffer.allocate(32);
        writeBuffer.put(new Date().toString().getBytes());
        //切换到读取模式
        writeBuffer.flip();

        while (true) {
            writeBuffer.rewind();
            socketChannel.write(writeBuffer);
            readBuffer.clear();
            socketChannel.read(readBuffer);
            TimeUnit.SECONDS.sleep(5);

        }

    }

}