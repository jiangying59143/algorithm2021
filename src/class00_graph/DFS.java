package class00_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DFS {
    public static void process(Node node){
        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            for (Node next : temp.nexts) {
                if(!set.contains(next)){
                    stack.push(temp);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break; // be careful
                }
            }
        }
    }

    public static void main(String[] args) {
        process(Node.generateNode());
    }
}
