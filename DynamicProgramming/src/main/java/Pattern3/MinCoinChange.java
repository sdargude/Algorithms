package Pattern3;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
 we are asked to find the minimum number of coins needed to make up that amount.

Denominations: {1,2,3}
Total amount: 5
Output: 2
Explanation: We need minimum of two coins {2,3} to make a total of '5'

Denominations: {1,2,3}
Total amount: 11
Output: 4
Explanation: We need minimum four coins {2,3,3,3} to make a total of '11'


Solution:
    Base 1:
        d[]; // denomination.

        int foobar ( sum, index) {

            int count1, count2 = Int.max;

            if (sum == 0) {
                return 0;
            }

            if (index == d.length)
                return Int.max;


            c = foobar(sum-d[index], index);
            if (c==0){
                count1 = c +1;
            }

            c1 = foobar(sum,index+1);
            if (c1==0){
                count2 = c1+1;
            }


            return  min(count1,count2);

        }

 */

public class MinCoinChange {

    public static int coinCount(int d[], int sum, int index) {

        int c1 = Integer.MAX_VALUE;

        if (sum == 0) return 0;

        if (index >= d.length) return Integer.MAX_VALUE;



        if (d[index] <= sum ) {
            int res = coinCount(d,sum-d[index],index);
            if (res != Integer.MAX_VALUE) c1 = res + 1;
        }

        int c2 = coinCount(d,sum,index+1);

        return Math.min(c1,c2);
    }


    public static void main(String args[]) {
        int d[] = {1,2,3};
        System.out.println(coinCount(d,5,0));

    }
}
