package neu.info6205.edu;
import java.util.List;

public class Solution {
    public int connectedSquareSum(int graph_nodes, List<Integer> graph_from, List<Integer> graph_to){

        int[] comtents = new int[graph_nodes];
        for (int i = 0; i < graph_nodes; ++i) {
            comtents[i] = i;
        }

        for (int i = 0; i < graph_from.size(); ++i) {
            int tg = graph_to.get(i);
            int src = graph_from.get(i);

            int oriTg = rootFind(comtents, tg);
            int oriSrc = rootFind(comtents, src);

            comtents[oriTg] = oriSrc;
        }
        // count the size for each component

        int[] counter = new int[comtents.length];
        for (int num : comtents) { ++counter[num]; }

        // Calculate the result

        int sum = 0;
        for (int num : counter) {
            sum += num * num;
        }
        return sum;
    }
    // Find the root of the component recursively
    // Optimization 1: path compression
    // Optimization 2: path balance
    private int rootFind(int[] comtents, int index) {
        while (index != comtents[index]) {
            index = comtents[index];
        }
        return index;
    }

}
