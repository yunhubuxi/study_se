# juc
## Semaphore
1. 执行 release 操作的线程不一定非得是执行了 acquire 方法的线程
2. 确实有很多坑，获取两个，释放一个
3. 获取的时候抛出异常，多释放一个，造成许可证多了
4. 获取锁的过程中，线程可能被别的线程终端，这个时候就会抛出异常
    

acquire：获取一个许可，可指定数量

release：释放一个许可，可指定数量

availablePermits：获取可用许可数量

drainPermits：排空可用许可数量，返回可用数量值
