package gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class GCTargetTest {

    private final static ReferenceQueue<GCTarget> REFERENCE_QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) throws Exception {
        test();
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        // 检查关联的引用队列是否为空
        Reference<? extends GCTarget> reference;
        while ((reference = REFERENCE_QUEUE.poll()) != null) {
            if (reference instanceof GCTargetWeakReference) {
                System.out.println("In queue, id is: " +
                        ((GCTargetWeakReference) (reference)).id);
            }
        }
    }

    static void test() {
        GCTarget str = new GCTarget(String.valueOf(2));
        GCTargetWeakReference weakReference = new GCTargetWeakReference(str,
                REFERENCE_QUEUE);
    }
}
