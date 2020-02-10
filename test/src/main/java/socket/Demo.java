package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
    //发送核心方法
    public String send(String send) throws IOException {
        Socket socket = new Socket();
        String rtn = null;
        BufferedWriter writer = null;
        OutputStreamWriter ow = null;
        OutputStream os = null;
        try{
            os = socket.getOutputStream();
            ow = new OutputStreamWriter(os);
            writer = new BufferedWriter(ow);
            char [] sendChar = send.toCharArray();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(char ch:sendChar){
                list.add((int)ch);
            }
            //进行加密操作
//            list = encry(list);
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                writer.write(it.next());
            }
            writer.flush();
            rtn = "发送成功！";
        }finally{
            //注意：直接关闭流将会导致socket关闭，只能通过shutdownOutput/input的方式关闭流
            //另外，流关闭之后，相当于关闭底层的连接，除非新new个socket，否则和客户端的连接相当于断开
//          if(writer!=null){
//              writer.close();
//          }
//          if(ow!=null){
//              ow.close();
//          }
//          if(os!=null){
            //os.close();
//          }
            //socket.shutdownOutput();流关闭之后，相当于关闭底层的连接，除非新<br>new个socket，否则和客户端的连接相当于断开
        }
        return rtn;
    }
}
