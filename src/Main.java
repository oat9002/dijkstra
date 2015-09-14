import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);
        char start,end;
        System.out.print("Enter start node : ");
        start = input.next().charAt(0);
        System.out.print("Enter end node : ");
        end = input.next().charAt(0);
        input.close();
        char[] travel;
        shortestPath(graph, start);
        System.out.println("\nHere we go!");
        printGraph(graph);
        System.out.println("\nPath");
        travel = journey(graph,start,end);
        for(int i =  travel.length - 1;i >= 0;i--) {
            if(travel[i] != ' ') {
                System.out.print(travel[i] + " ");
            }
        }
        System.out.println();
    }

    public static void  printGraph(Graph g)
    {
        for(int i = 0;i < g.returnSize();i++) {
            System.out.println("vertex : " + g.vertex[i].name + " distance : " + g.vertex[i].distance + " path : " + g.vertex[i].path);
        }
    }

    public static char[] journey(Graph g,char start,char end)
    {
        char[] travel = new char[g.returnSize()];
        for(int i = 0;i < travel.length;i++) {
            travel[i] = ' ';
        }
        int index = 0;
        while(start != end) {
            for (int i = 0; i < g.returnSize(); i++) {
                if(start == end) {
                    break;
                }
                if(g.vertex[i].name == end) {
                    travel[index++] = g.vertex[i].name;
                    end = g.vertex[i].path;
                }
            }
        }
        travel[index++] = start;
        return travel;
    }

    public static void shortestPath(Graph g,char start)
    {
        int vs = 0;
        int countVT = 0;
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
            g.vertex[vs].known = true;
            int min = 0;
            boolean first_min = true;
            for (int i = 0; i < g.returnSize(); i++) {
                if (g.adj[vs].weight[i] != 0) {
                    if(!g.vertex[i].known) {
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
            }
            for (int i = 0; i < g.returnSize(); i++) {
                if (g.adj[vs].weight[i] == min) {
                    vs = i;
                    break;
                }
            }
           // System.out.println("count : " + countVT);
           // printGraph(g);
            countVT++;
        }
    }


}
