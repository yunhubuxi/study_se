package xmltest;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static void main(String[] args) throws Exception{
        getResources("classpath*:*.xml");
    }

    public static Map<String, String> getResources(String path) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(path);
        System.out.println(resources.toString());
        if (resources == null) {
            return null;
        } else {
            Charset utf8 = Charset.forName("UTF8");
            HashMap contents = new HashMap();
            HashMap urls = new HashMap();
            for (int i = 0; i < resources.length; ++i) {
                byte[] buffer = FileCopyUtils.copyToByteArray(resources[i].getInputStream());
                String filename = resources[i].getFilename();
                if (contents.containsKey(filename)) {
                    // if (logger.isWarnEnabled()) {
                    //     logger.warn("Metadata load from Resource, filename {} [override],  {} will override {}", filename, resources[i].getURL(), urls.get(filename));
                    // }
                }
                urls.put(filename, resources[i].getURL());
                contents.put(filename, new String(buffer, utf8));
                // if (logger.isInfoEnabled()) {
                //     logger.info("Metadata load from Resource, filename: {}, url: {}", filename, resources[i].getURL());
                // }
            }
            return contents;
        }
    }
}
