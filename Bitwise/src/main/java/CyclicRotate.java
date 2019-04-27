/* Problem:

 Cyclic Rotate Bits  say an number (6) stored in a 4 bit integer is represented as 0110

 Left rotation by 1 is : 1100
 Left rotation by 2 is : 1001

 Right rotations by 1 is : 0011
 right totations by 2 is : 1001


Solution:

Number of bits is N: e.g 4.

Left Rotation by d places:

    Left = X<<d;
    Right = X>>N-d;

    result = Left | Right.


 */

public class CyclicRotate {
    static int N = 32;

    static int leftrotate(int x, int d) {
        int left = x << d;
        int right = x>> N-d;

        return left|right;
    }

    public static void main(String [] args) {
        System.out.println(leftrotate(16,2));
    }
}
