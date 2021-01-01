package producer;

public class Main {
    public static void main(String[] args) {
        Storage storage = createStorage(4);
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Producer(storage));

        Thread c1 = new Thread(new Consumer(storage));
        Thread c2 = new Thread(new Consumer(storage));
        Thread c3 = new Thread(new Consumer(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }

    static Storage createStorage(int i) {
        switch (i) {
            case 1:
                return new Storage1();
            case 2:
                return new Storage2();
            case 3:
                return new Storage3();
            case 4:
                return new Storage4();
            default:
                return null;
        }
    }

}
