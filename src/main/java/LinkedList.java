


class LinkedList<E> {
    private Node<E> head;
    private int size;

    public Node<E> head(){ return head; }

    public int size(){
        return size;
    }

    private void inc(){
        size++;
    }

    private void dec(){
        size--;
    }

    public void checkHead(){
        if(head==null){
            throw new IllegalArgumentException("Index out of bounds, list is empty");
        }
    }

    public E first(){
        checkHead();
        return head.value;
    }

    public E last(){
        checkHead();
        return getAt(size-1);
    }

    public E getAt(int index){
        checkHead();
        if(index>=size||index<0){
            throw new IllegalArgumentException("index out of bounds");
        }
        if(index==0){
            return first();
        }
        Node<E> node = head;
        int count = 0;
        while(node.next!=null){
            if(count==index){
                return node.value;
            }
            node=node.next;
            count++;
        }
        return node.value;
    }

    public void insert(E value){
        if(size==0){
            insertFirst(value);
            return;
        }
        Node<E> n = new Node(value);
        Node<E> node = head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=n;
        inc();

    }

    public void insertFirst(E value){
        Node<E> n = new Node(value);
        n.next=head;
        head=n;
        inc();
    }

    public void insertAt(int index, E value){
        checkHead();
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insert(value);
            return;
        }
        Node<E> n = new Node(value);
        int count=0;
        Node<E> node = head;
        while(node.next!=null){
            if(index==count+1){
                n.next=node.next;
                node.next=n;
                inc();
                return;
            }
            node=node.next;
            count+=1;

        }
    }

    public void deleteFirst(){
        checkHead();
        if(size==1){
            head=null;
            dec();
            return;
        }
        head = head.next;
        dec();
        return;
    }

    public void deleteLast(){
        checkHead();
        deleteAt(size-1);
        return;
    }

    public void deleteAt(int index){
        checkHead();
        if(index<0||index>=size){
            throw new IllegalArgumentException("Index out of bounds");
        }
        if(index==0){
            deleteFirst();
            dec();
            return ;
        }
        Node<E> node = head;
        int count=0;
        while(node.next!=null){
            if(size-1==index&&count==index-1){
                node.next=null;
                dec();
                return;
            }
            if(count==index-1){
                node.next=node.next.next;
                dec();
                return;
            }
            node=node.next;
            count++;
        }
    }

    public void printFirst(){
        System.out.println(first());
    }

    public void printLast(){
        System.out.println(last());
    }

    public void printAt(int index){
        System.out.println(getAt(index));
    }

    public void printAll(){
        checkHead();
        Node<E> node = head;
        while(node.next!=null){
            System.out.println(node.value);
            node=node.next;
        }
        System.out.println(node.value);
        return;
    }



}

class Node<E>{
     E value;
     Node next;

    Node(E value){
        this.value=value;
        this.next=null;
    }
    Node(){};
}
