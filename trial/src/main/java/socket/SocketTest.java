package socket;


import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        new Thread(()->{
            try {
                Socket socket = serverSocket.accept();
            } catch (Exception ex) {
            }
        }).start();

        //获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());//获取计算机名
        System.out.println(address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分
        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        InetAddress address3 = InetAddress.getByName("www.taobao.com");
        System.out.println(address2.getHostAddress());
        System.out.println(address3.getHostAddress());
    }
}
