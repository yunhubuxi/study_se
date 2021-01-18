package alibaba;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BiSetTest {
    public static void main(String[] args)
    {
        Random random=new Random();

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10000;i++)
        {
            int randomResult=random.nextInt(100);
            list.add(randomResult);
        }
        // System.out.println("产生的随机数有");
        // for(int i=0;i<list.size();i++)
        // {
        //     System.out.println(list.get(i));
        // }
        BitSet bitSet=new BitSet(2000000000);
        for(int i=0;i<10000;i++)
        {
            bitSet.set(list.get(i));
        }

        System.out.println("===================");
        long[] longs = bitSet.toLongArray();
        System.out.println(longs.length);
        System.out.println("===================");
        System.out.println(bitSet.nextSetBit(1000000));
        System.out.println("遍历");
        // 遍历
        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i + 1)) {
            System.out.println(i);
        }
        System.out.println("===================");
        System.out.println(bitSet.size());
        System.out.println(bitSet.length());
        System.out.println(bitSet.cardinality());
        System.out.println(ObjectSizeCalculator.getObjectSize(bitSet) / (1024*1024) + "MB");
        System.out.println(ClassLayout.parseInstance(new BitSet(10000)).toPrintable());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new int[5]).toPrintable());
        System.out.println(ClassLayout.parseInstance(new Integer[5]).toPrintable());

        // System.out.println("0~1亿在上述随机数中有"+bitSet.cardinality());
        // for (int i = 0; i < 100000000; i++)
        // {
        //     if(bitSet.get(i))
        //     {
        //         System.out.println(i);
        //     }
        // }
    }
}
