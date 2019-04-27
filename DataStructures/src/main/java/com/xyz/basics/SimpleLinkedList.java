package com.xyz.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CustomLinkedList <E>{


    private Node head;
    private Node end;
    private int size = 0;


    Node <E> add(E item) {
        if (head== null){
            head = new Node (null, null, item);
            size+=1;
            end=head;
        }else {
            size+=1;
            Node<E> temp =new Node (end, null, item);
            end.next = temp;
            end = temp;
        }
        return end;
    }


    boolean remove(E item) {
        Node<E> temp = head;


        while(temp.next != null) {
            if (temp.item.equals(item)) {
                break;
            }
            temp = temp.next;
        }


        if (temp.previous != null) {
            temp.previous.next = temp.next;
        }else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        } else {
            end = temp.previous;
        }


        temp.item = null;
        size--;
        return true;
    }

    int getSize() {
        return size;
    }

    void traverseforward() {
        Node<E> temp = head;
        while(temp != null){
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    void traversebackward(){
        Node<E> temp = end;
        while(temp != null) {
            System.out.println(temp.item);
            temp = temp.previous;
        }
    }

    void getHead() {
        System.out.println(head.item);
    }

    void getTail() {
        System.out.println(end.item);
    }

    boolean hasNext(Node<E> node){
        if (node.next != null) return true;
        return false;
    }



    private class Node <E> {
        Node<E> next;
        Node<E> previous;
        E item;
        Node (Node<E> previous, Node<E> next, E item) {
            this.next = next;
            this.previous = previous;
            this.item = item;
        }
    }




}

public class SimpleLinkedList {
   public static void main( String [] args){
       CustomLinkedList<Integer> cl = new CustomLinkedList<>();
       cl.add(1);
       cl.add(2);
       cl.add(3);
       cl.add(4);
       cl.remove(4);
       cl.add(5);
       cl.getSize();
       cl.traverseforward();
       cl.getHead();
       cl.getTail();
       cl.traversebackward();


       Map<Integer, Integer> map = new HashMap<>();

       List<Integer> list = new ArrayList<>();

       list.add(1);
       list.add(2);

       int a[] = list.stream().mapToInt(i->i).toArray();
       System.out.println(a[0] + " " + a[1]);


       map.put(1,10);
       map.put(2,20);
       map.put(10,1);

       map.keySet().stream().forEach(System.out::println);
       map.values().stream().forEach(System.out::println);



       System.out.println(map.containsKey(1) && map.containsKey(10) || map.containsKey(10) && map.containsKey(1));


       for (Map.Entry e: map.entrySet()) {
           System.out.println(e.getKey() + "   " + e.getValue());
       }



    }
}
