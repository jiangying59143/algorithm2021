package class00_graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BFS {
    public static void process(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value);
            for (Node next : temp.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }


    public static void main(String[] args) {
        process(Node.generateNode());
    }
}
