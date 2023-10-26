import java.util.*;
public class Stacks {

    //Implementation of Stack using ArrayList
    static class Stack1{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            return top;
        }

    }

    //Implementation of Stacks using LinkedList

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack2{
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }

        //Push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        //Pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

    }
    //1)Push at Bottom of Stack

    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);

    }

    //2)Reverse a String using Stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    //3)Reverse a Stack
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    //4)Stock Span
    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }
    //5)Next Greater Element
    public static void nextGreaterElement(int arr[],int nxtGreater[]){//O(n)
        Stack<Integer> r = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            //1)while
            while(!r.isEmpty() && arr[r.peek()]<=arr[i]){
                r.pop();

            }
            //2)if-else
            if(r.isEmpty()){
                nxtGreater[i] = -1;
            }
            else{
                nxtGreater[i] = arr[r.peek()];
            }

            //3)push in Stack
            r.push(i);
        }

    }
    //6)Valid parenthesis
    public static boolean isValid(String str){//O(n)
        Stack<Character> s = new Stack<>();

        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            //opening
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            else{
                //closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')')||
                        (s.peek() == '{' && ch == '}')||
                        (s.peek() == '[' && ch == ']')){
                    s.pop();

                }else{
                    return false;
                }
            }
        }

        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }


    }
    //7)Duplicate Parentheses
    public static boolean isDuplicate(String str){//O(n)
        Stack<Character> s = new Stack<>();

        for(int i = 0;i< str.length();i++){
            char ch = str.charAt(i);

            //closing
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;


                }
                if(count <1){
                    return true;//duplicate
                }else{
                    s.pop();//opening pair
                }
            }else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }

    //8)Max area in Histogram
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        //next smaller Right-O(n)
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left-O(n)
        s = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }



        //Current Area : width = j-i-1=nsr[i]-nsl[j]-1
        for(int i = 0;i<arr.length;i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println("Max area in histogram = "+maxArea);

    }



    public static void main(String[] args){
//        Stack<Integer> s = new Stack<>();
//        s.push(1);
//        s.push(2);
//        s.push(3);

//        pushAtBottom(s,4);
//        while(!s.isEmpty()){
//            System.out.println(s.pop());
//        }
//        String str = "abc";
//        String result = reverseString(str);
//        System.out.println(result);
//        reverseStack(s);
//        printStack(s);
//        int stocks[] = {100,80,60,70,60,85,100};
//        int span[] = new int[stocks.length];
//        stockSpan(stocks,span);
//        for(int i = 0;i<span.length;i++){
//            System.out.println(span[i]+" ");
//        }
//        int arr[] = {6,8,0,1,3};
//        int nxtGreater[] = new int[arr.length];
//        nextGreaterElement(arr,nxtGreater);
//Printing the values present in nxtGreater Array-Index
//        for(int i = 0;i<nxtGreater.length;i++){
//            System.out.print(nxtGreater[i]+" ");
//        }
//        System.out.println();
//        String str = "(({})[]";
//        System.out.println(isValid(str));
//        String str = "((a+b))";//true
//        String str2 = "(a-b)";//false
//        System.out.println(isDuplicate(str));
        int arr[] = {2,1,5,6,2,3};//heights in histogram
        maxArea(arr);






    }
}
