package com.hy.tt.algorithm;

/**
 * @auther thy
 * @date 2019/8/14
 */
public class SingleLinkListReversal {

    static class Node{
        int num;
        volatile Node next;

        public Node(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext(Node node){
            if(node.next == null){
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    '}';
        }
    }

    static Node linklist(){
        Node head = new Node(1);
        Node node2 = new Node(2) ;
        Node node3 = new Node(3) ;
        Node node4 = new Node(4) ;
        Node node5 = new Node(5) ;
        Node node6 = new Node(6) ;
        Node node7 = new Node(7) ;
        Node node8 = new Node(8) ;

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        return head;
    }

    /**
     * 反转 ,最重要的是,
     * node.next.next = node 把当前节点设置成下一个节点的 next节点, 2个节点反转
     * node.next  = null;  当前节点next节点为空
     * @param linkList
     * @return
     */
    static Node reverse(Node linkList){
        if(linkList == null || linkList.next == null){
            return linkList;
        }
        Node reverse = reverse(linkList.next);
        linkList.next.next  = linkList;
        linkList.next = null;
        return reverse;
    }


    static Node reverseWhile(Node linkList){
        if(linkList == null){
            return linkList;
        }
        Node preNode = null;
        Node nextNode ;
        while(linkList != null){
            nextNode = linkList.next;
            linkList.next = preNode;
            preNode = linkList;
            linkList = nextNode;
        }
        return preNode;
    }


    /**
     * 分组反转  12345678 --->  32165478
     * @param linkList
     * @param k
     * @return
     */
    static Node reverse(Node linkList, int k){

        Node temp = linkList;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        if(temp == null){
            return linkList;
        }

        Node nextNode = temp.next;
        temp.next = null;

        Node reverse = reverse(linkList);
        Node reverse1 = reverse(nextNode, k);

        linkList.next = reverse1;

        return reverse;
    }


    /**
     * 分组反转  12345678 --->  12543876
     * @param linkList
     * @param k
     * @return
     */
    static  Node handstandReverse(Node linkList, int k){
        Node temp = linkList;
        int size = size(temp);
        int a = size % k;
        if(a != 0){
            for (int i = 1; i < a; i++) {
                temp = temp.next;
            }
        }
        Node nextNode = temp.next;
        temp.next = null;
        Node reverse = reverse(nextNode, k);
        Node node = lastNode(linkList);
        node.next =  reverse;

        return linkList;
    }

    static int size(Node node){
        int size = 0;
        if(node != null){
            size = 1;
        }
        while(node.hasNext(node)){
            size++;
            node = node.next;
        }
        return size;
    }

    static Node lastNode(Node node){
        Node lastNode = null;
        while(node != null){
            lastNode = node;
            node = node.next;
            if(node == null){
                return lastNode;
            }
        }
        return lastNode;
    }

    public static void main(String[] args) {
        Node linklist = linklist();
//        Node reverse = reverse(linklist, 3);
////        Node reverse = reverse(knode);

//        Node reverse = handstandReverse(linklist, 3);
        Node reverse = reverseWhile(linklist);
        System.out.println(reverse.toString());
        Node node = reverse.getNext();
        while(node != null){
            System.out.println(node.toString());
            node = node.next;
        }

    }

}
