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
                        g.vertex[i].path = g.vertex[i].name;
                    }
                }
            }
            int min = 0;
            boolean first = true;
            for(int i = 0;i < g.returnSize();i++) {
                if(g.adj[vs].weight[i] != 0) {
                    if(first) {
                        min = g.adj[vs].weight[i];
                        first = false;
                    }
                    else {
                        if(g.adj[vs].weight[i] < min) {
                            min = g.adj[vs].weight[i];
                        }
                    }
                }
            }
            for(int i = 0;i < g.returnSize();i++) {
                if(g.adj[vs].weight[i] == min) {
                    vs = i;
                    break;
                }
            }
        }
    }


}
