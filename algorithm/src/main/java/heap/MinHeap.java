package heap;

/**
 * 最小堆
 * @param <AnyType>
 */
public class MinHeap<AnyType extends Comparable<? super AnyType>> {
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;
    private AnyType[] array;

    public MinHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[currentSize + 1];
        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * 方法名：percolateDown
     * 说明：
     */
    private void percolateDown(int position) {
        AnyType temp = array[position];
        int child;
        for (; position * 2 <= currentSize; position = child) {
            child = 2 * position;
            if (child != currentSize
                    && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(temp) < 0)
                array[position] = array[child];

            else
                break;
        }
        array[position] = temp;
    }

    /**
     * 方法名：buildHeap
     * 说明：下滤的顺序很关键 从中间开始不断向上依次下滤
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    public void insert(AnyType x) {
        if (currentSize >= array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        while (hole > 1 && x.compareTo(array[hole / 2]) < 0) {
            array[hole] = array[hole / 2];
            hole /= 2;
        }
        array[hole] = x;
    }

    private void enlargeArray(int capacity) {
        AnyType[] oldArr = array;
        AnyType[] newArr = (AnyType[]) new Comparable[capacity];
        for (int i = 1; i < array.length; i++)
            newArr[i] = oldArr[i];
        array = newArr;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public AnyType deleMin() {
        if (!isEmpty()) {
            AnyType min = array[1];
            array[1] = array[currentSize--];
            percolateDown(1);
            return min;
        }
        return null;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
            sb.append(array[i] + " ");
        return new String(sb);
    }
}
