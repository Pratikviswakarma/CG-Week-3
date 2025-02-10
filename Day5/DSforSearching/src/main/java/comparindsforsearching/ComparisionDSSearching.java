package comparindsforsearching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparisionDSSearching {

    // Using Array with linear search
    public static void linearSearch(int arr[],int target){
       long s=System.nanoTime();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                break;
            }
        }
        long e=System.nanoTime();
        System.out.println("Time taken by linear search "+(e-s));
    }

    //Using HashSet
    public static  void hashSet(int arr[],int target){
        long s=System.nanoTime();
        Set<Integer> hs=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        for(int ele:hs){
            if(ele==target){
                break;
            }
        }
        long e=System.nanoTime();
        System.out.println("Time taken by HashSet in search "+(e-s));
    }

    //Using Treeset for searching
    public static void treeSet(int[] arr,int target){
        long s=System.nanoTime();
        Set<Integer> ts=new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            ts.add(arr[i]);
        }
        for(int ele:ts){
            if(ele==target){
                break;
            }
        }
        long e=System.nanoTime();
        System.out.println("Time taken by TreeSet in search "+(e-s));
    }
    //Main method
    public static void main(String[] args) {
        int[] arr={50,45,12,451,24,514,78,2,4,55,6,789,4,51,2,450,455,24,61,3,54,789,55,741,66,75,185,812};
        int target=185;
        linearSearch(arr,target);
        hashSet(arr,target);
        treeSet(arr,target);

    }
}
