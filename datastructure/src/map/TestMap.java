package map;

import java.util.ArrayList;
import set.FileOperation;

public class TestMap {

    private static double testMap(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }

    public static void main(String[] args) {

        String filename = "src/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + "s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("LinkedList Map: " + time2 + "s");

        System.out.println();

        AVLMap<String, Integer> avlMap = new AVLMap<>();
        double time3 = testMap(avlMap, filename);
        System.out.println("AVL Map: " + time3 + "s");

//        System.out.println("Pride and Prejudice");
//        ArrayList<String> words = new ArrayList<>();
//        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
//
//            LinkedListMap<String, Integer> map = new LinkedListMap<>();
//            for(String word: words) {
//                if (map.contains(word))
//                    map.set(word, map.get(word) + 1);
//                else
//                    map.add(word, 1);
//            }
//
//            System.out.println("Total different words: " + map.getSize());
//            System.out.println("Frequency of PRIDE: " + map.get("pride"));
//            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//        }
//
//        System.out.println("Pride and Prejudice");
//        ArrayList<String> words = new ArrayList<>();
//        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
//            System.out.println("Total words: " + words.size());
//
//            BSTMap<String, Integer> map = new BSTMap<>();
//            for(String word: words) {
//                if (map.contains(word))
//                    map.set(word, map.get(word) + 1);
//                else
//                    map.add(word, 1);
//            }
//
//            System.out.println("Total different words: " + map.getSize());
//            System.out.println("Frequency of PRIDE: " + map.get("pride"));
//            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//        }
    }
}
