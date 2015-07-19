package Varargs;

/**
 * Created by 优华 on 2015/6/25.
 */
public class TestVarargs {
    public static void main(String[] args) {
        TestVarargs.printNum0(12,3);
    }

    public static void printNum0(int... nums) {
        if (nums.length > 0) {
            System.out.println(nums[0]);
        }else{
            System.out.println("no input");
        }
    }
}
