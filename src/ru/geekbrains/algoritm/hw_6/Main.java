package ru.geekbrains.algoritm.hw_6;

import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        BST<Integer,String>[] trees=new BST[20];
        int i=0;
        for (int j = 0; j <20 ; j++) {
            trees[j] = new BST<>();
            while (trees[j].height()<6) {
                trees[j].add((Integer)random.nextInt(200)-100,"node #"+i);
            }
            i=0;
            System.out.println(trees[j].isBalanced());
        }

    }
}
