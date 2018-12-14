package ru.geekbrains.algoritm.hw_6;



public class BST<Key extends Comparable<Key>, Value> {

    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size=1;
            this.left=null;
            this.right=null;
        }
    }

    private Node root=null;

    private boolean isEmpty(){
        return root==null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node==null){
            return 0;
        }
        else {
            return node.size;
        }
    }
    public Value find(Key key){
        return find(key,root);
    }

    private Value find (Key key, Node node) throws IllegalArgumentException{
        if (key==null){
            throw new IllegalArgumentException("key should not be null");
        }
        if (key.compareTo(node.key)==0){
            return node.value;
        } else if (key.compareTo(node.key)<0 && node.left!=null){
            return find(key,node.left);
        } else if (key.compareTo(node.key)>0 && node.right!=null){
            return find(key,node.right);
        } else
            return null;
    }

    public void add(Key key,Value value){
        Node node = new Node(key,value);
        add(root,node);
    }

    private void add(Node position,Node node){
        if (isEmpty()){
            root = new Node(node.key,node.value);
            return;
        }
        int temp=node.key.compareTo(position.key);
        if (temp==0){
            position.value=node.value;
            return;
        }
        else if (size(position)==1) {
            if (temp<0){
                position.left=node;
            } else {
                position.right=node;
            }
        } else if(temp<0){
            if(position.left==null) {
                position.left=node;
            } else {
                add(position.left,node);
            }
        } else {
            if(position.right==null) {
                position.right=node;
            } else {
                add(position.right,node);
            }
        }
        position.size=size(position.left)+size(position.right)+1;
    }

    public Value delete(Key key){
        return delete(key, root);
    }

    private Value delete(Key key, Node node){
        if (isEmpty()) return null;
        int temp=key.compareTo(node.key);
        Value result= node.value;
        if (temp==0){
            if (node.size==1){
                node.size=0;
                node.key=null;
                node.value=null;
                return result;
            } else if (node.right==null){
             // node=node.left;
                // не могу понять почему присваиваение просто не работает, а надо присваивать все поля
                  node.key=node.left.key;
                node.value=node.left.value;
                node.right=node.left.right;
                node.size=node.left.size;
                node.left=node.left.left;
            } else if (node.left==null){
              //  node=node.right;
                node.key=node.right.key;
                node.value=node.right.value;
                node.left=node.right.left;
                node.size=node.right.size;
                node.right=node.right.right;
            } else if (node.right.left==null){
                node.size= node.right.size+node.left.size;
                node.key=node.right.key;
                node.value=node.right.value;
                node.right=node.right.right;
            } else {
                Node tempNode=deleteLeft(node.right);
                node.value=tempNode.value;
                node.key=tempNode.key;
                tempNode=null;
            }
        } else if (temp<0){
            delete(key,node.left);
            if (node.left.size==0){
                node.left=null;
            }
            result=null;
        } else {
            delete(key,node.right);
            if (node.right.size==0){
                node.right=null;
            }
            result=null;
        }
            node.size=size(node.left)+size(node.right)+1;
        return result;
    }

    private Node deleteLeft(Node node){
        if (node.left==null){
            Node temp = new Node(node.key,node.value);
            delete(temp.key,root);
            return temp;
        } else{
            node.size=size(node.left)+size(node.right)+1;
            return deleteLeft(node.left);
        }
    }



}
