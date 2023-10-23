public class Recursion {
    //1.Print Numbers in Decreasing Order
    public static void PrintDecreasing(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        PrintDecreasing(n - 1);


    }
    //2.Print Numbers in Increasing Order
    public static void PrintIncreasing(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        PrintIncreasing(n-1);
        System.out.println(n);
    }
    //3.Print Factorial of a Number n
    public static int Factorial(int n){
        if(n == 0){
            return 1;
        }
        int fact = n * Factorial(n-1);
        return fact;
    }
    //4.Sum of n Natural Numbers
    public static int SumN(int n){
        if(n == 1){
            return 1;
        }
        int sumNm1 = SumN(n-1);
        int sum = n + sumNm1 ;
        return sum;
    }
    //5.Nth term of Fibonacci Series
    public static int Fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int FibNm1 = Fibonacci(n-1);
        int FibNm2 = Fibonacci(n-2);
        int Fib = FibNm1 + FibNm2;
        return Fib;
    }
    //6.Check if an array is sorted or not(ascending)
    public static boolean isSorted(int arr[],int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }
    //7.First occurence of an element in an array.
    public static int firstOcc(int arr[],int key,int i){
        if (i == arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr,key,i+1);

    }
    //8.Last occurence of an element in an array.
    public static int lastOcc(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOcc(arr,key,i+1);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    //9.print x^n
    public static int XpowN(int x,int n){
        if (n == 0){
            return 1;
        }
        int xpown = x * XpowN(x,n-1);
        return xpown;
    }
    //10.x^n(optimised)
    public static int OptimisedPower(int x,int n){
        if(n == 0){
            return 1;
        }
        int HalfPower = OptimisedPower(x,n/2);
        int HalfPowerSq = HalfPower * HalfPower ;

        if(n%2 != 0){
            return x*HalfPowerSq;
        }
        return HalfPowerSq;
    }
    //11.Tiling Problem
    //given a 2 x n board and tiles of 2 x 1 ,count number of ways to tile the given board(either vertical or horizontal)
    public static int TilingProblem(int n){// 2 x n (floor size)
        if (n == 0 || n == 1){
            return 1;
        }
        //Vertical choice
        int fnm1 = TilingProblem(n-1);
        //Horizontal choice
        int fnm2 = TilingProblem(n-2);
        int totways = fnm1 + fnm2;
        return totways;



    }
    //12.Return duplicates in a String
    public static void removeDuplicates(String str,int idx,StringBuilder newStr,boolean map[]){
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true){
            removeDuplicates(str,idx+1,newStr,map);

        }
        else{
            map[currChar - 'a'] = true;
            removeDuplicates(str,idx+1,newStr.append(currChar),map);
        }
    }
    //13.Friends pairing problem
    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        //single
//        int fnm1 = friendsPairing(n-1);
//        //pair
//        int fnm2 = friendsPairing(n-2);
//        int pairWays = (n-1) * fnm2;
//        int totWays = fnm1 + pairWays;
//        return totWays;
        return friendsPairing(n-1)+ (n-1)*friendsPairing(n-2);

    }
    //14.Binary Strings Problem
    public static void printBinStrings(int n,int lastPlace,String str){
        //base case
        if(n == 0){
            System.out.println(str);
            return;
        }

        printBinStrings(n-1,0,str+"0");
        if(lastPlace == 0){
            printBinStrings(n-1,1,str+"1");
        }
    }
    //15.Print occurences of an element
    public static void allOccurences(int arr[],int key,int i)  {
        if(i==arr.length) {
            return;
        }
        if(arr[i] ==key) {
            System.out.print(i+" ");
        }
        allOccurences(arr,key,i+1);
    }
    //16.Tower of Hanoi
    public static void towerofHanoi(int n,String src,String helper,String dest){
        if (n == 1){
            System.out.println("transfer disk "+ n + " from " + src +" to " + dest);
            return;
        }
        towerofHanoi(n-1,src,dest,helper);
        System.out.println("transfer disk "+ n + " from " + src +" to " + dest);
        towerofHanoi(n-1,helper,src,dest);


    }
    public static void main(String[] args){
        //Solution depends on the solution of the smaller instances of the same Problem.
        //PrintDecreasing(10);
        //PrintIncreasing(10);
        //System.out.println(Factorial(5));
        //System.out.println(SumN(5));
        //System.out.println(Fibonacci(5));
        //int arr[] = {1,2,2,4,3,4};
        //System.out.println(isSorted(arr,0));
        //System.out.println(firstOcc(arr,4,0));
        //System.out.println(lastOcc(arr,4,0));
        //System.out.println(XpowN(2,10));
        //System.out.println(OptimisedPower(2,10));
        //System.out.println(TilingProblem(2));
        //String str = "apnacollege";
        //removeDuplicates(str,0,new StringBuilder(""),new boolean[26]);
        //System.out.println(friendsPairing(3));
        //printBinStrings(3,0,"");
        //int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        //int key = 2;
        //allOccurences(arr,key,0);
        towerofHanoi(2,"S","H","D");


    }
}
