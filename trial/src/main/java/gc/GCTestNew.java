package gc;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.concurrent.TimeUnit;

/**
 * @author gaoyuanqing
 * @Description 测试大对象进入老年代后如何尽快回收
 * ====================================堆内存相关参数=============================================
 * -Xmx20m -Xms20m -Xmn10m
 * -Xmx20m 最大堆内存20M
 * -Xms20m 最小堆内存20M 为了防止JVM频繁向操作系统申请内存
 * -Xmn10m 年轻代内存10M 默认情况下，年轻代内存是整个堆内存的八分之三 指定为10M，就是设置了年轻代是整个堆内存的二分之一
 * -XX:NewRatio=n:设置年轻代和年老代的比值。如:为3，表示年轻代与年老代比值为1：3，年轻代占整个年轻代年老代和的1/4
 * -XX:SurvivorRatio=n:年轻代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：3，表示Eden：Survivor=3：2，一个Survivor区占整个年轻代的1/5
 * -XX:PretenureSizeThreshold 大对象阈值，与年轻代整个大小有关，手动设置大小也没起作用
 * -XX:MaxPermSize=16m:设置持久代大小为16m
 * -XX:MaxTenuringThreshold=0：设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。对于年老代比较多的应用，可以提高效率。如果将此值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概论。
 * -Xss128k 设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。更具应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右
 * ====================================垃圾回收器设置=============================================
 * -XX:+UseG1GC
 * -XX:+UseSerialGC:设置串行收集器
 * -XX:+UseParallelGC:设置并行收集器
 * -XX:+UseParalledlOldGC:设置并行年老代收集器
 * -XX:+UseConcMarkSweepGC:设置并发收集器（经观察，工作也是非常优秀的，内存和CPU都比较稳定）
 * -XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
 * -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
 * -XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
 * -XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
 * -XX:ParallelGCThreads=n:设置并发收集器年轻代收集方式为并行收集时，使用的CPU数。并行收集线程数。
 * ====================================日志打印相关参数=============================================
 * -XX:+PrintGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps -XX:+PrintGC
 * -XX:+PrintGCApplicationStoppedTime
 * -XX:+PrintGCApplicationConcurrentTime
 * -XX:+PrintHeapAtGC
 * ====================================日志打印相关参数=============================================
 * 安装示例代码运行程序，如果使用默认的垃圾回收期，那么内存是有可能到达百分之九十的，但是dump堆的时候，获取不到任何有用信息，因为占用内存的主要是垃圾回收器
 * 如果使用G1垃圾回收器，那么内存不会飙到百分之就是，最多五十多。G1适用于超过6个G的说法说不对的，小内存也能很好的工作
 * @date 2021年07月24日 14:52
 * -Xmx2500M
 * -Xms2500M
 * -Xmn1000M
 * -XX:MetaspaceSize=512m
 * -XX:MaxMetaspaceSize=512m
 * -Xss256K
 * -XX:+DisableExplicitGC
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:+CMSParallelRemarkEnabled
 * -XX:+UseCMSCompactAtFullCollection
 * -XX:CMSFullGCsBeforeCompaction=0
 * -XX:+CMSClassUnloadingEnabled
 * -XX:LargePageSizeInBytes=128M
 * -XX:+UseFastAccessorMethods
 * -XX:+UseCMSInitiatingOccupancyOnly
 * -XX:CMSInitiatingOccupancyFraction=70
 * -XX:SoftRefLRUPolicyMSPerMB=1000
 * -XX:+TraceClassLoading
 * -XX:+TraceClassUnloading
 * -XX:+PrintClassHistogram
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintHeapAtGC
 * -Xloggc:/export/Logs/gcDetail.log
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=/export/Logs/gc.hprof
 * -Dsun.net.client.defaultConnectTimeout=60000
 * -Dsun.net.client.defaultReadTimeout=60000
 * -Djmagick.systemclassloader=no
 * -Dnetworkaddress.cache.ttl=300
 * -Dsun.net.inetaddr.ttl=300
 * -DumpCenter=config-th.ump.jd.local
 * -Duser.timezone=GMT+07"
 */
public class GCTestNew {
    public static void main(String[] args) throws Exception {
        allM();
//        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
//            System.err.println(memoryPoolMXBean.getName() + "  总量:" + memoryPoolMXBean.getUsage().getCommitted() + "   使用的内存:" + memoryPoolMXBean.getUsage().getUsed());
//        }
//        for (int i = 0; i < 100000; i++) {
//            System.out.println("==============================================");
//            allM();
//            TimeUnit.MILLISECONDS.sleep(10);
//        }
        new TestMey();
        new TestMey();
        new TestMey();
        new TestMey();
        new TestMey();
        new TestMey();
        for (int i = 0; i < 1000; i++) {
            System.err.println("执行一次");
            TimeUnit.MILLISECONDS.sleep(20000);
            new TestMey();
        }
    }
    private static void allM() {
        byte[] b1 = new byte[40 * 1024 * 1024];
        b1 = null;
    }

    private static class TestMey {
        TestMey() {
            byte[] b1 = new byte[2000 * 1024 * 1024];
        }
    }

}
