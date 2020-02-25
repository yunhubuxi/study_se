import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DownFile {

    public static void main(String[] args) throws Exception {
        // downLoadFromUrl("http://172.20.55.84:8099/download?filepath=/UFSoft.U8.OrderCenter.Portal.exe", "", "D:\\test.txt", "");
        downLoadFromUrl("http://localhost:8099/download?filepath=/UFSoft.U8.OrderCenter.Portal.exe", "", "D:\\test.txt", "");
        Executor executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        downLoadFromUrl("http://localhost:8099/download?filepath=/UFSoft.U8.OrderCenter.Portal.exe", "", "D:\\test.txt", "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath, String toekn) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn.setRequestProperty("lfwywxqyh_token", toekn);

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        String result = Arrays.toString(getData);
        System.out.println(result.length() > 50 ? result.substring(0, 50) : result);
        System.out.println(Thread.currentThread().getName());

        //文件保存位置
//        File saveDir = new File(savePath);
//        if (!saveDir.exists()) {
//            saveDir.mkdir();
//        }
//        File file = new File(saveDir + File.separator + fileName);
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(getData);
//        if (fos != null) {
//            fos.close();
//        }
        if (inputStream != null) {
            inputStream.close();
        }


        System.out.println("info:" + url + " download success");

    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


}


