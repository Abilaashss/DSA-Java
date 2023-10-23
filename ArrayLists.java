import java.util.ArrayList;
import java.util.Collections;
public class ArrayLists {
    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    //1.Store water

    public static int storeWater(ArrayList<Integer> height){//O(n^2)
        int maxWater = 0;
        //Brute force-O(n^2)
        for(int i=0;i< height.size();i++){
            for(int j=i+1;j< height.size();j++){
                int ht =Math.min(height.get(i),height.get(j));
                int width = j-i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;

    }
    //2-pointer approach
    public static int storeWaterOptimised(ArrayList<Integer> height){
        int maxWater = 0;
        int lp=0;
        int rp = height.size()-1;
        while(lp<rp){
            //calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currWater = ht*width;
            maxWater = Math.max(maxWater,currWater);

            //update ptr
            if(height.get(lp)<height.get(rp)){
                lp++;

            }
            else{
                rp--;
            }
        }
        return maxWater;
    }

    //2.Pair Sum-Brute Force and two pointer approach
    public static boolean pairSum(ArrayList<Integer> list,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    //Two pointer approach
    public static boolean pairSumOptimised(ArrayList<Integer> list,int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp != rp) {
            //case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;

            }

            //case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                //case 3
                rp--;
            }
        }
        return false;
    }
    //3.Pair sum-2
    public static boolean pairSum2(ArrayList<Integer> list,int target){//O(n)
        int bp = -1;
        int n= list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){//breaking point
                bp = i;
                break;
            }
        }

        int lp = bp+1;//smallest element
        int rp = bp;//largest

        while(lp != rp){
            //case 1
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp) < target){
                lp = (lp+1)%n;
            }
            else{
                //case 3
                rp = (n+rp - 1)% n;
            }
        }
        return false;

    }
    //Monotonic ArrayList
    public static boolean isMonotonic(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = true;
        int n = list.size();

        for(int i=0;i<n-1;i++){
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }
            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }






    public static void main(String[] args){
//        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<String> list2 = new ArrayList<>();
//        ArrayList<Boolean> list3 = new ArrayList<>();

        //Operations
        //1)Add element
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
        //System.out.println(list);

        //2)Get element

//        int element = list.get(0);
//        System.out.println(element);

        //3)Remove element
//        list.remove(2);
//        System.out.println(list);

        //4)Set element at index

//        list.set(1,30);
//        System.out.println(list);

        //5)Contains Element

//        System.out.println(list.contains(1));

        //System.out.println(list.size());
//        swap(list,1,3);
//        System.out.println(list);
//        Collections.sort(list);//ascending order
//        System.out.println(list);
//        //descending order
//        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);

        //Multidimensional ArrayList
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        mainList.add(list);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(4);
//        mainList.add(list2);


//        for(int i=0;i< mainList.size();i++){
//            ArrayList<Integer> currList = mainList.get(i);
//            for(int j=0;j<currList.size();j++){
//                System.out.print(currList.get(j)+" ");
//
//            }
//            System.out.println();
//        }
//        System.out.println(mainList);

        //ArrayList<Integer> height = new ArrayList<>();
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(3);
//        height.add(7);
//        //System.out.println(storeWater(height));
//        System.out.println(storeWaterOptimised(height));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        int target = 5;
//        System.out.println(pairSum(list,target));
        //System.out.println(pairSumOptimised(list,target));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(11);
//        list.add(15);
//        list.add(6);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        int target = 18;
//        System.out.println(pairSum2(list,target));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(isMonotonic(list));







    }
}
