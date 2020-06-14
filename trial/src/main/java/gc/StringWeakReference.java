package gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class StringWeakReference extends WeakReference<String> {
    // 弱引用的ID
    public String id;

    public StringWeakReference(String string,
                               ReferenceQueue<? super String> queue) {
        super(string, queue);
    }


    protected void finalize() {
        System.out.println("Finalizing StringWeakReference " + id);
    }
}
