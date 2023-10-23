import java.util.*;
public class BitManipulation {
    public static void oddorEven(int n){
        int bitMask=1;
        if((n & bitMask)==0){
            System.out.println("Even Number");
        }
        else{
            System.out.println("Odd Number");
        }
    }
    public static int getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n & bitMask)==0){
            return 0;
        }
        else {
            return 1;
        }

    }
    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n,int i){
        int bitMask=~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n,int i,int newBit){
//        if(newBit==0){
//            clearIthBit(n,i);
//        }
//        else{
//            setIthBit(n,i);
//        }
        n=clearIthBit(n,i);
        int bitMask=newBit<<i;
        return n|bitMask;

    }
    public static int ClearIbit(int n,int i){
        int bitMask=(~0)<<i;
        return n & bitMask;
    }
    public static int ClearRangeOfBits(int n,int i,int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n&bitMask;
    }
    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;

            }
            n=n>>1;
        }
        return count;

    }
    public static int fastExponentiation(int a,int n){
        int ans=1;
        while (n>0){
            if((n & 1) != 0){
                ans = ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args){
        //oddorEven(23);
        //System.out.println(getIthBit(10,3));
        //System.out.println(setIthBit(10,2));
        //System.out.println(clearIthBit(10,1));
        //System.out.println(updateIthBit(10,2,1));
        //System.out.println(ClearIbit(15,2));
        System.out.println(ClearRangeOfBits(10,2,4));
        System.out.println(fastExponentiation(3,5));




    }
}
