public class Practice {
    public static void main(String[] args) {
            LinkedList<Integer> ll = new LinkedList<>();
            ll.insert(1);
            ll.insert(2);
            ll.insert(3);
            ll.insert(4);
            ll.insert(5);
            //ll.insert(6);
        System.out.println(System.currentTimeMillis());
        System.out.println(slowSize(ll.head()));
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(fastSize(ll.head()));
        System.out.println(System.currentTimeMillis());
    }

    //slow
    static public <E> int slowSize(Node<E> head){
        Node<E> slow = head;
        int count = 0;
        while (slow!=null){
            count+=1;
            slow = slow.next;
        }
        return count;
    }

    //fast
    static public <E> int fastSize(Node<E> head){
        Node<E> fast = head;
        int count = 0;
        while(fast!=null&&fast.next!=null){
            count+=1;
            fast = fast.next.next;
            if(fast==null){
                return count*2;
            }
            if(fast.next==null){
                return count*2+1;
            }
        }
        return count;
    }

}
