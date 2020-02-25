package iotest;

public class Test {
    public static void main(String[] args) {
        byte[] bs = new byte[2048];
        for (int i = 0; i <bs.length ; i++) {
            bs[i] = (byte) i;
        }
        String aa = new String(bs);
        System.out.println(aa);
        System.out.println(bs.length);
        String bb = "\u0001\u0001\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F�������������������������������������������������������������������������������������������������������������������������������� \u0001\u0002\u0003\u0004\u0005\u0006\t\n" +
                "\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007F��������������������������������������������������������������������������������������������������������������������������������\n";
        byte[] cd = bb.getBytes();
        System.out.println(cd.length);
    }
}
