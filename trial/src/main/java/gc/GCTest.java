package gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class GCTest {

    private final static ReferenceQueue<String> REFERENCE_QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) throws Exception {
        test();
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        // 检查关联的引用队列是否为空
        Reference<? extends String> reference;
        while ((reference = REFERENCE_QUEUE.poll()) != null) {
            if (reference instanceof StringWeakReference) {
                System.out.println("In queue, id is: " +
                        ((StringWeakReference) (reference)).id);
            }
        }
    }

    static void test() {
        String str = new String("aaa");
        StringWeakReference weakReference = new StringWeakReference(str,
                REFERENCE_QUEUE);
    }
}
