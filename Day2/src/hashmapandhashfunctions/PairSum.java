package hashmapandhashfunctions;

import java.util.HashMap;
import java.util.Map;
public class PairSum {
    public static HashMap<Integer,int[]> pairSum(int arr[],int target){
        HashMap<Integer,int[]> hm=new HashMap<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]+arr[i]==target){
                int a=arr[i-1];
                int b=arr[i];
                hm.put(target, new int[]{a,b});
            }
        }
        return hm;
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60,70,80,90};
        int target=50;
        HashMap<Integer,int[]> hm=pairSum(arr, target);

        for(Map.Entry<Integer,int[]> ia: hm.entrySet()){
            System.out.println("The target is "+ia.getKey());
            int temp[]=ia.getValue();
            System.out.print("With Array element "+temp[0]+" And "+temp[1]);
        }
    }
}
