package array;

/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 5, 5, 6};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int currentLength = nums.length, tag = 0, cursor;
        while (tag < currentLength) {
            cursor = tag + 1;
            while (cursor < currentLength) {
                if (nums[tag] == nums[cursor]) {
                    removeElement(nums, cursor);
                    currentLength--;
                } else {
                    cursor++;
                }
            }
            tag++;
        }
        return currentLength;
    }

    public static void removeElement(int[] nums, int index) {
        int length = nums.length;
        for (int i = index; i < length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
