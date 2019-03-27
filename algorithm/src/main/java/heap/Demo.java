package heap;

public class Demo {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 9,8,7,6,5, 4, 3, 2};
        MinHeap min = new MinHeap(arr);
        min.insert(10);
        min.deleMin();
        System.out.println(min);
        Integer[] arr2 = new Integer[] { 1, 2, 3, 4, 5,6,7,8,9,10};
        MaxHeap max = new MaxHeap(arr2);
        max.deleMax();
        max.insert(10);
        System.out.println(max);
    }
}
