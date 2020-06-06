package thread.local;

public class NewBasic {
    public static ThreadLocal<Long> x = ThreadLocal.withInitial(() -> 100L);

    public static void main(String[] args) {
        System.out.println(x.get());
    }
}
