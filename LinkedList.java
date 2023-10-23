import java.util.*;
public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static int size;

    public void addFirst(int data){   //O(1)
        //step1=create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;

        }

        //step2 = NewNode next = head
        newNode.next = head;

        //step3-NewNode as Head
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){//O(n)
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1;temp = prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;

        }
        //prev : i = size -2
        Node prev = head;
        for(int i = 0;i<size-2;i++){
            prev = prev.next;

        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }
    public static int helper(Node head,int key){//O(n)
        //base case
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;

    }

    public static int recSearch(int key){
        return helper(head,key);

    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        if(n ==sz){
            head = head.next;//removeFirst
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }
    //Slow-Fast Approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;//slow is my middle Node
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step1-find mid
        Node midNode = findMid(head);

        //step2-reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node right = prev;//right half head
        Node left = head;

        //step3-check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;

            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;//last node
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }

        //remove cycle ->last.next = null
        prev.next = null;
    }
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head1;
            head2 = head2.next;
            temp = temp.next;

        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){  //O(nlogn)
        if(head==null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left and right MergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;

        //alt merge
        while(left!=null && right!=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        //LinkedList ll = new LinkedList();
        //ll.print();
//        ll.head = new Node(1);
//        ll.head.next = new Node(2);
//        ll.addFirst(2);
//        ll.addFirst(1);
        //ll.print();
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.addMiddle(2,3);
        //ll.print();
        //System.out.println(ll.size);
//        ll.removeFirst();
//        ll.print();
//        ll.removeLast();
//        ll.print();
//        System.out.println(ll.size);
        //System.out.println(ll.itrSearch(3));
        //System.out.println(recSearch(3));
        //ll.reverse();
        //ll.print();
//        ll.deleteNthfromEnd(3);
//        ll.print();
//        System.out.println(ll.checkPalindrome());

        //Detecting cycle
//        head = new Node(1);
//        Node temp = new Node(2);
//        head.next = temp;
//        temp.next = new Node(3);
//        temp.next.next = new Node(4);
//        temp.next.next.next = temp;
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
        ll.zigZag();
        ll.print();






    }
}
