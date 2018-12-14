package ru.geekbrains.algoritm.hw_6;

import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        BST<Integer,String> bst = new BST<>();
       // for (int i = 0; i <10 ; i++) {
         //   bst.add((Integer)i,"node #"+i);
        //         bst.add((Integer)random.nextInt(5),"node #"+i);
       // }

        bst.add(3,"node 1");
        bst.add(5,"node 2");
        bst.add(1,"node 3");
        bst.add(2,"node 4");
        bst.add(0,"node 5");
        bst.add(4,"node 6");
        bst.add(6,"node 7");
        bst.add(7,"node 8");
        bst.add(8,"node 9");


        for (int i = 0; i <9 ; i++) {
            System.out.println(bst.find((Integer)i));
        }
            bst.delete(6);
        for (int i = 0; i <9 ; i++) {
            System.out.println(bst.find((Integer)i));
        }


        System.out.println(bst.size());


    }
}
