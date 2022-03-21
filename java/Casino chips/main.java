//task url: https://www.codewars.com/kata/5e0b72d2d772160011133654

import java.util.Arrays;

class Solution{
    public int solve(int [] arr){
        for (int nums=0;nums>=0;nums++) {

            int zeros=0; // count how many containers are empty

            for (int i : arr)
                if (i <= 0)
                    zeros++;

            if(zeros>1) // if 2 or more containers are empty shutdown counting loop
                return nums; //return number of days

            Arrays.sort(arr); // sort containers

            if(arr[0]>0)  // if first container is empty get from second and always take from third
                arr[0]--;
            else
                arr[1]--;
            arr[2]--;
        }
        return 0;
    }
}
public class main {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(new int[]{8,2,8}));
    }
}
