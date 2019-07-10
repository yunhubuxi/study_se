import sun.misc.Unsafe;

import java.nio.ByteBuffer;

public class Test {
    public static void main(String[] args) {
        TestA a = new TestA();
        Unsafe unsafe = Unsafe.getUnsafe();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
    }
}
