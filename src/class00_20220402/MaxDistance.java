package class00_20220402;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaxDistance {
    public static class Info{
        public int height;
        public int distance;

        public Info(int height, int distance) {
            this.height = height;
            this.distance = distance;
        }
    }

    public static int getMaxDistance(Node head){
        if(head == null){
            return 0;
        }
        return process(head).distance;
    }

    public static Info process(Node node){
        if(node == null){
            return new Info(0,0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int distance = Math.max(Math.max(leftInfo.distance, rightInfo.distance), leftInfo.height+ rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(height, distance);
    }

    public static int maxDistance1(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = getPrelist(head);
        HashMap<Node, Node> parentMap = getParentMap(head);
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    public static ArrayList<Node> getPrelist(Node head) {
        ArrayList<Node> arr = new ArrayList<>();
        fillPrelist(head, arr);
        return arr;
    }

    public static void fillPrelist(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static HashMap<Node, Node> getParentMap(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, null);
        fillParentMap(head, map);
        return map;
    }

    public static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }

    public static int distance(HashMap<Node, Node> parentMap, Node o1, Node o2) {
        HashSet<Node> o1Set = new HashSet<>();
        Node cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        Node lowestAncestor = cur;
        cur = o1;
        int distance1 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance1++;
        }
        cur = o2;
        int distance2 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance2++;
        }
        return distance1 + distance2 - 1;
    }

    public static void main(String[] args) {
        int times = 10000;
        while(times-- > 0){
            Node head = BinaryTree.generateRandomNode(5,100);
            if(MaxDistance.getMaxDistance(head) != MaxDistance.maxDistance1(head)){
                System.out.println("Oops!");
                BinaryTree.printTree(head);
                return;
            }
        }
        System.out.println("success !");
    }
}
