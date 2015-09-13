/**
 * Created by oat90 on 9/9/2558.
 */
public class Main {

    public static void main(String args[])
    {

        CSVFileReader csv = new CSVFileReader("test.csv");
        String[][] table = csv.getFileValue();

        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        // Initial graph's value
        Graph graph = new Graph(table[0].length);
        for(int i = 0;i < table[0].length;i++) {
            Vertex v = new Vertex(table[0][i].toCharArray()[0]);
            graph.vertex[i] = v;
        }
        int arr[] = new int[table[0].length];
        for(int i = 1;i < table.length;i++) {
            for(int j = 0;j < table[i].length;j++) {
              arr[j] = Integer.parseInt(table[i][j]);
            }
            Adjacency adj = new Adjacency(table[0].length,arr);
            graph.adj[i - 1] = adj;
        }
        // Test graph's value
        for(int i = 0; i < table[0].length;i++) {
            System.out.print(graph.vertex[i].name + " ");
            for(int j = 0;j < table[0].length;j++) {
                System.out.print(graph.adj[i].weight[j]);
            }
            System.out.println();
        }
        System.out.println("\nHere we go!");       System.out.println("\nHere we go!");
        shortestPath(graph, 'a');
        printGraph(graph);
    }

    public static void  printGraph(Graph g)
    {
        for(int i = 0;i < g.returnSize();i++) {
            System.out.println("vertex : " + g.vertex[i].name + " distance : " + g.vertex[i].distance + " path : " + g.vertex[i].path);
        }
    }

    public static void shortestPath(Graph g,char start)
    {
        int vs = 0;
        int vs_temp = 0;
        int countVT = 0;
        boolean first = true;
        for(int i = 0;i < g.returnSize();i++) {
            if(g.vertex[i].name == start) {
                vs = i;
                break;
            }
        }
        g.vertex[vs].distance = 0;
        while(countVT < g.returnSize()) {
            for(int i = 0;i < g.returnSize();i++) {
                if(g.adj[vs].weight[i] != 0) {
                    if(g.vertex[i].distance > g.adj[vs].weight[i] + g.vertex[vs].distance) {
                        g.vertex[i].distance = g.adj[vs].weight[i] + g.vertex[vs].distance;
                        g.vertex[i].path = g.vertex[vs].name;
                    }
                }
            }
            int min = 0;
            boolean first_min = true;
            while(true) {
                for (int i = 0; i < g.returnSize(); i++) {
                    if (g.adj[vs].weight[i] != 0) {
                        if (first_min) {
                            min = g.adj[vs].weight[i];
                            first_min = false;
                        } else {
                            if (g.adj[vs].weight[i] < min) {
                                min = g.adj[vs].weight[i];
                            }
                        }
                    }
                }
                if(vs_temp != min) {
                    break;
                }
            }
            if(!first) {
                for (int i = 0; i < g.returnSize(); i++) {
                    if (g.adj[vs].weight[i] == min) {
                        vs_temp = vs;
                        vs = i;
                        break;
                    }
                }
            }
            else {
                for (int i = 0; i < g.returnSize(); i++) {
                    if (g.adj[vs].weight[i] == min) {
                        vs = i;
                        break;
                    }
                }
            }
            System.out.println("count : " + countVT);
            printGraph(g);
            if(first) {
                first = false;
            }
            countVT++;
        }
    }


}
