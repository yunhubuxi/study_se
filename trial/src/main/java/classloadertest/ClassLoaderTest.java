package classloadertest;

import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassLoaderTest {
    private static ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
    private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    public static void main(String[] args) throws ClassNotFoundException{
        // System.out.println(System.getProperty("java.class.path"));
        // try {
        //     Class typeLoaded = Class.forName("classloadertest.TestBean");
        //     System.out.println(typeLoaded.getClassLoader());
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
        // Class typeLoaded = Class.forName("org.slf4j.LoggerFactory");
        // System.out.println(typeLoaded);
        // ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
        // System.out.println(loggerFactoryClassLoader.getClass());
        // System.out.println(loggerFactoryClassLoader.getParent());
        LinkedHashSet staticLoggerBinderPathSet = new LinkedHashSet();

        try {
            ClassLoader loggerFactoryClassLoader = LoggerFactory.class.getClassLoader();
            Enumeration paths;
            if (loggerFactoryClassLoader == null) {
                paths = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
            } else {
                paths = loggerFactoryClassLoader.getResources(STATIC_LOGGER_BINDER_PATH);
            }

            while(paths.hasMoreElements()) {
                URL path = (URL)paths.nextElement();
                staticLoggerBinderPathSet.add(path);
            }
        } catch (IOException var4) {
            Util.report("Error getting resources from path", var4);
        }

        if (isAmbiguousStaticLoggerBinderPathSet(staticLoggerBinderPathSet)) {
            Util.report("Class path contains multiple SLF4J bindings.");
            Iterator i$ = staticLoggerBinderPathSet.iterator();

            while(i$.hasNext()) {
                URL path = (URL)i$.next();
                Util.report("Found binding in [" + path + "]");
            }

            Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }

    }

    private static boolean isAmbiguousStaticLoggerBinderPathSet(Set<URL> binderPathSet) {
        return binderPathSet.size() > 1;
    }
}
