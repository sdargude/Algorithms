/* Design a LRU cache using Hashmap and  linked list



LRU cache supports following operations:

Size of LRU cache is fixed.

1. Add Node.
        a. If size of cache is less than max size, add a node to left of the linked list.
            add an entry in map <key,node>.

        b. else , remove end tail node from the linked list. Add a node to the left of the linked list.
            add an entry in a map <key, node>.



2. Get Node.

    a. if the node is same as head return head node.

    b. else lookup node in map,  if found, remove the entry from linked list.
       add the node to the left of the linked list and adjust the head.

 */

import java.util.HashMap;
import java.util.Map;

public class Lru {

    class Node {
        int value;
        int key;
        Node next;
        Node prev;

        Node (int key,int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    };

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;


    Lru(int size) {
        this.size = size;
        map = new HashMap<>();
        head = null;
        tail = null;
    }


    int get(int key){

        if (key == head.key)
            return head.value;


        Node node = map.get(key);

        if (node == null) return -1; //Not found.

 //       System.out.println(node.value+ " " + node.prev);

        if (node.key != tail.key) {
            Node prev = node.prev;
            prev.next = node.next;

            if (node.next != null)  //If not null.
                node.next.prev = prev;
             }
        else
        if (node.next==null) {
            node.prev.next = null;
            tail = node.prev;
        }

        node.next=head;
        head.prev = node;
        head=node;
        head.prev=null;

        return node.value;
    }

    void printLRU(){
        Node node = head;
        System.out.println("Printing Forward...");
        while(node != null){
            System.out.println(node.key + " " + node.value);
            node = node.next;
        }
    }

    void printReverse(){
        Node node = tail;
        System.out.println("Printing Reverse..");
        while(node!=null){
            System.out.println(node.key + " " + node.value);
            node=node.prev;
        }
        System.out.println("Done.");
    }

    int insert(int key, int value) {

        if (map.size() == 0 || head == null) {
            head = new Node(key,value);
            tail = head;
            map.put(key,head);
            return key;
        }

        if ( map.size() < size) {
            Node node = new Node (key,value);
            map.put(key,node);
            head.prev=node;
            node.next = head;
            head = node;
            return key;
        }

        if (map.size() >= size){
            int endkey = tail.key;
            map.remove(endkey);
            tail=tail.prev;
            tail.next=null;
            insert(key,value);
        }

        return key;
    }



    public static void main(String []args) {

        Lru lru = new Lru(5);

        lru.insert(1,10);
        lru.insert(3,30);
        lru.insert(2,20);
        lru.insert(5,50);
        lru.printLRU();
        lru .printReverse();
        System.out.println(" Now going to full");
        lru.insert(7,70);
        lru.insert(6,60);
        System.out.println("Head " + lru.head.value);
        lru.printLRU();
        lru .printReverse();

        lru.get(5);


          System.out.println("Aftet get");
          lru.printLRU();
          lru.printReverse();


            int i=5;
         System.out.println(i%10 +" " + i/10);
    }

}
