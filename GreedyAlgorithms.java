import java.util.*;
public class GreedyAlgorithms {

public static void activitySelection(){
    int start[] = {1,3,0,5,8,5};
    int end[] = {2,4,6,7,9,9};




    //end time basis sorted
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    //1st activity
    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];

    for(int i=1;i<end.length;i++){
        if(start[i]>=lastEnd){
            maxAct++;
            ans.add(i);
            lastEnd = end[i];
        }
    }
    System.out.println("Max activities = "+maxAct);
    for(int i=0;i<ans.size();i++){
        System.out.println("A"+ans.get(i)+" ");
    }
    System.out.println();


}

public static void fractionalKnapsack(){
    int val[] = {60,100,120};
    int weight[] = {10,20,30};
    int W = 50;
    double ratio[][] = new double[val.length][2];
    //0th col->idx; 1st col -> ratio
    for(int i = 0;i<val.length;i++){
        ratio[i][0] = i;
        ratio[i][1] = val[i]/(double)weight[i];
    }
    //ascending order
    Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
    int capacity = W;
    int finalVal = 0;

    for(int i=ratio.length-1;i>=0;i--){
        int idx = (int)ratio[i][0];
        if(capacity>=weight[idx]){
            finalVal += val[idx];
            capacity -= weight[idx];
        }else{
            //include fractional item
            finalVal += (ratio[i][1] * capacity);
            capacity = 0;
            break;
        }
    }

    System.out.println("Final value: "+ finalVal);

}

public static void MinAbsDiffPairs(){
    int A[] = {1,2,3};
    int B[] = {2,1,3};
    Arrays.sort(A);
    Arrays.sort(B);
    int minDiff = 0;

    for(int i=0;i<A.length;i++){
        minDiff += Math.abs(A[i]-B[i]);
    }
    System.out.println("Min absolute difference of pairs:"+minDiff);
}

public static void maxLengthChain(){//0(nlogn)
    int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

    Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
    int chainLen = 1;
    int chainEnd = pairs[0][1];//Last selected pair end//chain end

    for(int i = 1;i<pairs.length;i++){
        if(pairs[i][0]>chainEnd){
            chainLen++;
            chainEnd = pairs[i][1];

        }
    }
    System.out.println("Max length of chain = "+chainLen);
}

public static void indianCoins(){
    Integer coins[] = {1,2,5,10,20,50,100,500,2000};
    Arrays.sort(coins,Comparator.reverseOrder());

    int countOfCoins = 0;
    int amount = 590;
    ArrayList<Integer> ans = new ArrayList<>();

    for(int i = 0;i<coins.length;i++){
        if(coins[i]<amount){
            while(coins[i]<=amount){
                countOfCoins++;
                ans.add(coins[i]);
                amount-=coins[i];
            }
        }
    }
    System.out.println("Total (min) coins used "+countOfCoins);

    for(int i =0;i<ans.size();i++){
        System.out.print(ans.get(i)+" ");
    }
}
static class Job{
    int deadline;
    int profit;
    int id;//0(A),1(B),2(C)

    public Job(int i,int d,int p)
    {
        id = i;
        deadline = d;
        profit = p;
    }
}
public static void jobSequencing(){
    int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

    ArrayList<Job> jobs = new ArrayList<>();

    for(int i=0;i<jobsInfo.length;i++){
        jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));

    }

    Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);//Descending order of profit

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;
    for(int i=0;i<jobs.size();i++){
        Job curr = jobs.get(i);
        if(curr.deadline>time){
            seq.add(curr.id);
            time++;
        }
    }
    //print seq
    System.out.println("Max jobs = "+seq.size());
    for(int i=0;i<seq.size();i++){
        System.out.println(seq.get(i)+" ");
    }

}

public static void chocola(){
    int n = 4,m = 6;
    Integer costVer[] = {2,1,3,1,4};//m-1
    Integer costHor[] = {4,1,2};//n-1

    Arrays.sort(costVer,Collections.reverseOrder());
    Arrays.sort(costHor,Collections.reverseOrder());

    int h = 0,v=0;
    int hp=1,vp=1;
    int cost = 0;

    while(h<costHor.length && v< costVer.length){
        //vertical cost < hor cost
        if(costVer[v]<=costHor[h]){
            //horizontal cut
            cost+= (costHor[h]*vp);
            hp++;
            h++;
        }else{
            //Vertical cut
            cost+= (costVer[v]*hp);
            vp++;
            v++;
        }
    }
    while(h<costHor.length){
        cost+= (costHor[h]*vp);
        hp++;
        h++;
    }

    while(v<costVer.length){
        cost+= (costVer[v]*hp);
        vp++;
        v++;
    }
    System.out.println("Minimum cost of cuts = "+cost);
}

    public static void main(String[] args){

        //activitySelection();
//        fractionalKnapsack();
        //MinAbsDiffPairs();
        //maxLengthChain();
//        indianCoins();
        //jobSequencing();
        chocola();

}

}

