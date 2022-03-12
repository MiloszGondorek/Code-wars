import java.util.*;

class WeightSort {
    public static String orderWeight(String strng) {
        if(strng=="")
            return "";
        List<String> ret=new ArrayList<>();
        String[] numsAsString=strng.split(" ");
        long[][] allNums=new long[numsAsString.length][2];
        List<Integer> weights=new ArrayList<Integer>();
        for(int i=0;i<numsAsString.length;i++){
            int weight=0;
            for(char c:numsAsString[i].toCharArray()){
                weight+=Integer.parseInt(String.valueOf(c));
            }
            if(!weights.contains(weight)){
                weights.add(weight);
            }
            allNums[i][0]=Long.parseLong(numsAsString[i]);
            allNums[i][1]=weight;
        }
        Collections.sort(weights);
        for(int z:weights){
            List<String> nums=new ArrayList<String>();
            for(int i=0;i<numsAsString.length;i++){
                if(allNums[i][1]==z)
                    nums.add(String.valueOf(allNums[i][0]));
            }
            Collections.sort(nums);
            for(String s:nums){
                ret.add(s);
            }
        }
        return String.join(" ",ret);
    }
}
public class Main {
    public static void main(String[] args) {
        //"2000 103 123 4444 99"
        System.out.println(WeightSort.orderWeight("123456789123 2"));
    }
}
